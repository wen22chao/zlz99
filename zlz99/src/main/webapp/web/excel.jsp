<%@ page language="java" import="cn.tedu.store.entity.excel.TestExcelWrite" pageEncoding="gb2312"%>
<%@ page import="java.io.OutputStream" %>
<%
    String fname = "ѧУ���������";
    OutputStream os = response.getOutputStream();//ȡ�������
    response.reset();//��������
    
    //�����Ƕ������ļ����Ĵ���
    response.setCharacterEncoding("UTF-8");//������Ӧ���ݵı����ʽ
    fname = java.net.URLEncoder.encode(fname,"UTF-8");
    response.setHeader("Content-Disposition","attachment;filename="+new String(fname.getBytes("UTF-8"),"GBK")+".xls");
    response.setContentType("application/msexcel");//�����������
    /* SimpleExcelWrite sw = new SimpleExcelWrite(); */
    TestExcelWrite sw = new TestExcelWrite();
    sw.createExcel(os);

 %>
<html>
  <head>
    
    <title></title>

  </head>
  
  <body>
  
  <div>
  		�ļ��������أ����Ժ�
  </div>
  </body>
</html>