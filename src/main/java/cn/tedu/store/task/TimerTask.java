package cn.tedu.store.task;

import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * 
 * 类名称：TimerTask 类描述：定时器任务 创建人：geekfly 创建时间：Aug 29, 2016 10:56:27 AM
 * 
 * @version V1.0
 *
 */
@SuppressWarnings("unused")
@Component
public class TimerTask {
	/**
	 * 每天22点30启动任务
	 */
//  @Scheduled(cron = "0 08 10 ? * *")
	public void test1() {
		System.out.println("job1 开始执行..." + TimeUtils.getTime());
	}

//  @Scheduled(cron = "0/60 * * * * ?")//每隔5秒隔行一次 
	public void test2() {
		System.out.println("job2 开始执行11");

		System.out.println("-----分割线");

		// 1. 创建参数配置, 用于连接邮件服务器的参数配置
		Properties props = new Properties(); // 参数配置
		props.setProperty("mail.transport.protocol", "smtp"); // 使用的协议（JavaMail规范要求）
		props.setProperty("mail.smtp.host", SendMail.myEmailSMTPHost); // 发件人的邮箱的 SMTP 服务器地址
		props.setProperty("mail.smtp.auth", "true"); // 需要请求认证

		// PS: 某些邮箱服务器要求 SMTP 连接需要使用 SSL 安全认证 (为了提高安全性, 邮箱支持SSL连接, 也可以自己开启),
		// 如果无法连接邮件服务器, 仔细查看控制台打印的 log, 如果有有类似 “连接失败, 要求 SSL 安全连接” 等错误,
		// 取消下面 /* ... */ 之间的注释代码, 开启 SSL 安全连接。
		/*
		 * // SMTP 服务器的端口 (非 SSL 连接的端口一般默认为 25, 可以不添加, 如果开启了 SSL 连接, // 需要改为对应邮箱的 SMTP
		 * 服务器的端口, 具体可查看对应邮箱服务的帮助, // QQ邮箱的SMTP(SLL)端口为465或587, 其他邮箱自行去查看) final String
		 * smtpPort = "465"; props.setProperty("mail.smtp.port", smtpPort);
		 * props.setProperty("mail.smtp.socketFactory.class",
		 * "javax.net.ssl.SSLSocketFactory");
		 * props.setProperty("mail.smtp.socketFactory.fallback", "false");
		 * props.setProperty("mail.smtp.socketFactory.port", smtpPort);
		 */

		// 2. 根据配置创建会话对象, 用于和邮件服务器交互
		Session session = Session.getInstance(props);
		// 设置为debug模式, 可以查看详细的发送 log
		session.setDebug(true);

		// 3. 创建一封邮件
		MimeMessage message = null;
		try {
			message = SendMail.createMimeMessage(session, SendMail.myEmailAccount, SendMail.receiveMailAccount);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 4. 根据 Session 获取邮件传输对象
		Transport transport = null;
		try {
			transport = session.getTransport();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		}

		// 5. 使用 邮箱账号 和 密码 连接邮件服务器, 这里认证的邮箱必须与 message 中的发件人邮箱一致, 否则报错
		//
		// PS_01: 如果连接服务器失败, 都会在控制台输出相应失败原因的log。
		// 仔细查看失败原因, 有些邮箱服务器会返回错误码或查看错误类型的链接,
		// 根据给出的错误类型到对应邮件服务器的帮助网站上查看具体失败原因。
		//
		// PS_02: 连接失败的原因通常为以下几点, 仔细检查代码:
		// (1) 邮箱没有开启 SMTP 服务;
		// (2) 邮箱密码错误, 例如某些邮箱开启了独立密码;
		// (3) 邮箱服务器要求必须要使用 SSL 安全连接;
		// (4) 请求过于频繁或其他原因, 被邮件服务器拒绝服务;
		// (5) 如果以上几点都确定无误, 到邮件服务器网站查找帮助。
		//
		try {
			transport.connect(SendMail.myEmailAccount, SendMail.myEmailPassword);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		// 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人,
		// 密送人
		try {
			transport.sendMessage(message, message.getAllRecipients());
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		// 7. 关闭连接
		try {
			transport.close();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
