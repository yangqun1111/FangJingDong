package com.example.lenovo.fangjingdong.bean;

/**
 *
 */

public class Loginbean {
    /**
     * code : 0
     * data : {"createtime":"2017-11-15T14:09:17","gender":0,"mobile":"13701125154","money":0,"password":"123456","token":"4E2388C1DB8C507D9320BCE7D54E62EE","uid":672,"username":"13701125154"}
     * msg : 登录成功
     */

    private String code;
    private DataBean data;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataBean {
        /**
         * createtime : 2017-11-15T14:09:17
         * gender : 0
         * mobile : 13701125154
         * money : 0
         * password : 123456
         * token : 4E2388C1DB8C507D9320BCE7D54E62EE
         * uid : 672
         * username : 13701125154
         */

        private String createtime;
        private int gender;
        private String mobile;
        private int money;
        private String password;
        private String token;
        private int uid;
        private String username;

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
