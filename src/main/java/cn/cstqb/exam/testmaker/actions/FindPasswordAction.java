package cn.cstqb.exam.testmaker.actions;

import cn.cstqb.exam.testmaker.dao.impl.SendMail;
import cn.cstqb.exam.testmaker.entities.User;
import cn.cstqb.exam.testmaker.services.IUserService;

import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class FindPasswordAction extends BaseAction{
    @Inject
    protected IUserService userService;
    private String userName;
    private String userEmail;
    private String emailPassword;

    public String getModifiedPassword() {
        return modifiedPassword;
    }

    public void setModifiedPassword(String modifiedPassword) {
        this.modifiedPassword = modifiedPassword;
    }

    private String modifiedPassword;

    public FindPasswordAction(){}
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getEmailPassword() {
        return emailPassword;
    }

    public void setEmailPassword(String emailPassword) {
        this.emailPassword = emailPassword;
    }
    @Override
    public void validateInput() {

    }
    @Override
    protected String executeImpl() throws Exception {
//        System.out.println(userName);
//        System.out.println(userEmail);
//        System.out.println(emailPassword);
//    public String execute(){


//        String method = request.getParameter("method");
//
//        if(method.equals("find")){
//            String userName = request.getParameter("userName");
//            String userEmail = request.getParameter("userEmail");
//            String userPassword = request.getParameter("emailPassword");

//System.out.println(userEmail);
//            try {

//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
            boolean flag = false;

//            UserDaoImpl userDaoImp = new UserDaoImpl();
//                UserServiceImpl userService = new UserServiceImpl(userDaoImp);
                User user = userService.findUser(userName);

//                System.out.println(userService.+"---------------");
                if(user!=null&&userService.isEmailExists(userEmail)){
                    flag = true;
                }


//
            if(flag) {
                boolean changed = userService.changePassword(userName, user.getPassword(), modifiedPassword);
//                FindPassword findPassword = new FindPassword();
//                long currentTime = System.currentTimeMillis() + 120000;
//                Random random = new Random();
//                String signature = userName + "|" + currentTime + "|" + random.nextInt();
////                 String signature = MD5Util.MD5(key);
                if (changed) {
                    try {
//                    int res = findPassword.insertInfor(userName, userEmail, currentTime, signature);
//                    if (res == 1) {
                        SendMail sendmail = new SendMail();
//                        String url = "http://localhost:8081/tm/web/client/getPasswordPage.action+?uid=" + userName + "&validkey=" + signature;
                        String url = "您的密码为已修改为" + modifiedPassword;
                        sendmail.send(userEmail, url, emailPassword);
//                    }
                    } catch (AddressException e) {
//                    // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (MessagingException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                } else {
//                request.setAttribute("error", "用户名和邮箱不匹配，请重新输入！");
                    return "用户名和邮箱不匹配，请重新输入！";
                }
            }
        return null;
    }
}
