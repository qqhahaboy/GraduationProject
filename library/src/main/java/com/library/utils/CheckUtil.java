package com.library.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckUtil {

    /**
     * 判断两个string是否相等
     */
    public static boolean checkEquels(Object strObj0, Object strObj1) {
        String str0 = strObj0 + "";
        String str1 = strObj1 + "";
        if (str0.equals(str1)) {
            return true;
        }
        return false;
    }


    /**
     * 同时判断多个参数是否为空
     *
     * @param strArray
     * @return
     */
    public static boolean isNull(Object... strArray) {
        for (Object obj : strArray) {
            if (!"".equals(obj + "")) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判是否是字母
     *
     * @return
     */
    public static boolean isLetter(String txt) {
        if (isNull(txt)) {
            return false;
        }
        Pattern p = Pattern.compile("[a-zA-Z]");
        Matcher m = p.matcher(txt);
        if (m.matches()) {
            return true;
        }
        return false;
    }


    /**
     * 判断对象是否为空
     */
    public static boolean isNull(Object strObj) {
        String str = strObj + "";
        if (!"".equals(str) && !"null".equals(str)) {
            return false;
        }
        return true;
    }

    /**
     * 判断是否邮箱
     *
     * @param strObj
     * @return
     */
    public static boolean checkEmail(Object strObj) {
        String str = strObj + "";
        if (!str.endsWith(".com")) {
            return false;
        }
        String match = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
        Pattern pattern = Pattern.compile(match);
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否为电话号码
     */
    public static boolean checkPhone(Object phoneNumber) {
        boolean isValid = false;
        String expression = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{5})$";
        String expression2 = "^\\(?(\\d{3})\\)?[- ]?(\\d{4})[- ]?(\\d{4})$";
        CharSequence inputStr = phoneNumber + "";
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(inputStr);
        Pattern pattern2 = Pattern.compile(expression2);
        Matcher matcher2 = pattern2.matcher(inputStr);
        if (matcher.matches() || matcher2.matches()) {
            isValid = true;
        }
        return isValid;
    }

    /**
     * 监测是否为正确的手机号码
     *
     * @param mobile
     * @return
     */
//    "^(13[0-9]|14[579]|15[0-3,5-9]|17[0135678]|18[0-9])\\d{8}$"
    public static boolean isMobileCorrect(String mobile) {
//        String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17([6-8]|0))|(18[0-9]))\\d{8}$";
        String regex = "^(13[0-9]|14[579]|15[0-3,5-9]|17[0135678]|18[0-9])\\d{9}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(mobile);
        return matcher.matches();
    }

    /**
     * 判断是否为min到max位的字母或数字
     *
     * @param s
     * @param min
     * @param max
     * @return
     */
    public static boolean isAlphanumericRange(String s, int min, int max) {
        String regex = "^[a-z0-9A-Z]{" + min + "," + max + "}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

    /**
     * 判断是否为n为数字的验证码
     *
     * @param s
     * @param n
     * @return
     */
    public static boolean isVerificationCode(String s, int n) {
        String regex = "^[0-9]{" + n + "}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

    /**
     * 检查内容的长度是否大于等于要求
     *
     * @param
     * @param
     * @return
     */
    public static boolean checkLength(Object strObj, int length) {
        String str = strObj + "";
        if (str.length() >= length) {
            return true;
        }
        return false;
    }

    /**
     * 检查字符串的长度
     *
     * @param strObj
     * @param length
     * @return
     */
    public static boolean checkLengthEq(Object strObj, int length) {
        String str = strObj + "";
        if (str.length() == length) {
            return true;
        }
        return false;
    }

    /**
     * @param @param  strObj
     * @param @param  min
     * @param @param  max
     * @param @return 设定文件
     * @return boolean    返回类型
     * @throws
     * @Title: checkNum
     * @Description: 检查是否为数字，以及这个数在min与max之间，包含min与max
     */
    public static boolean checkNum(Object strObj, int min, int max) {
        String str = strObj + "";
        try {
            int number = Integer.parseInt(str);
            if (number <= max && number >= min) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * @param @param  strObj
     * @param @param  min
     * @param @param  max
     * @param @return 设定文件
     * @return boolean    返回类型
     * @throws
     * @Title: checkNumWithDecimal
     * @Description: 检查是否为数字，以及这个数在min与max之间，包含min与max,可以为小数
     */
    public static boolean checkNumWithDecimal(Object strObj, float min, float max) {
        String str = strObj + "";
        try {
            float number = Float.parseFloat(str);
            if (number <= max && number >= min) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * @param @param  strObj
     * @param @param  start
     * @param @param  end
     * @param @return 设定文件
     * @return boolean    返回类型
     * @throws
     * @Title: checkLength
     * @Description: 检查字符串的长度范围是否符合要求
     */
    public static boolean checkLength(Object strObj, int start, int end) {
        String str = strObj + "";
        if (str.length() >= start && str.length() <= end) {
            return true;
        }
        return false;
    }

    /**
     * @param @param  strObj
     * @param @param  num  倍数
     * @param @return 设定文件
     * @return boolean    返回类型
     * @throws
     * @Title: checkMoney
     * @Description: 检查金额是否为数字以及是否为一个数的倍数
     */
    public static boolean checkMoney(Object strObj, int num) {
        String str = strObj + "";
        try {
            int money = Integer.parseInt(str);
            if (money % num == 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 检查请求返回是否正确
     */
    public static boolean checkStatusOk(String status) {
        if ("2000000".equals(status)) {
            return true;
        }
        return false;
    }

    public static boolean checkStatusOk(int status) {
        if (2000000 == status) {
            return true;
        }
        return false;
    }

    /**
     * 检查string是否为o
     *
     * @param value
     * @return
     */
    public static boolean checkZero(String value) {
        int valueInt = StringUtil.toInt(value);
        if (valueInt == 0) {
            return true;
        }
        return false;
    }

    /**
     * 检查是否是网络链接
     *
     * @param url
     * @return
     */
    public static boolean checkURL(String url) {
        if (isNull(url)) {
            return false;
        }
        String regular = "(http|https)://[\\S]*";
        return Pattern.matches(regular, url);
    }

    /**
     * 检测文件链接
     * @param url
     * @return
     */
    public static boolean checkFileURL(String url) {
        if (isNull(url)) {
            return false;
        }
        String regular = "(file)://[\\S]*";
        return Pattern.matches(regular, url);
    }

    /**
     * 检查是否合法金额
     *
     * @param goal
     * @return
     */
    public static boolean checkIsGoal(String goal) {
        String regular = "^(([1-9]\\d*)|([0]))(\\.(\\d){0,2})?$";
        return Pattern.matches(regular, goal);
    }
    /**
     * 密码强度
     *
     * @return Z = 字母 S = 数字 T = 特殊字符
     */
    public static String checkPassword(String passwordStr) {
        String regexZ = "\\d*";
        String regexS = "[a-zA-Z]+";
        String regexZS = "\\w*";

        if ((passwordStr.length() > 5 && passwordStr.length() < 10) && passwordStr.matches(regexZ)) {
            return "弱";
        }
        if ((passwordStr.length() > 5 && passwordStr.length() < 10) && passwordStr.matches(regexS)) {
            return "弱";
        }
        if ((passwordStr.length() > 5 && passwordStr.length() < 10) && passwordStr.matches(regexZS)) {
            return "中";
        }
        if (passwordStr.length() > 9 && passwordStr.matches(regexZ)) {
            return "中";
        }
        if (passwordStr.length() > 9 && passwordStr.matches(regexS)) {
            return "中";
        }
        if (passwordStr.length() > 9 && passwordStr.matches(regexZS)) {
            return "强";
        }
        return passwordStr;
    }
}
