package com.sjf.util.utils;

import com.google.common.base.Objects;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Created by xiaosi on 16-12-21.
 */
public class JodaTimeUtil {

    public static String DATE_FORMAT = "yyyy-MM-dd";
    private static String FULL_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 获取当前时间
     * @return
     */
    public static String getCurrentDate(){
        return getCurrentDate(DATE_FORMAT);
    }
    /**
     * 获取当前时间
     * @param format
     * @return
     */
    public static String getCurrentDate(String format){

        if(StringUtils.isBlank(format)){
            format = DATE_FORMAT;
        }
        try{
            DateTime now = new DateTime();
            return now.toString(format);
        }
        catch (Exception e){
            return null;
        }

    }

    //------------------------------------------------------------------------------------------------------------------
    /**
     * 字符串时间转换为DateTime
     * @param dateStr 字符串时间
     * @param format 字符串时间格式
     * @return
     */
    public static DateTime dateStr2DateTime(String dateStr, String format){

        if(StringUtils.isBlank(dateStr)){
            return null;
        }

        try{
            DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(format);
            DateTime dateTime = DateTime.parse(dateStr, dateTimeFormatter);
            return dateTime;
        }
        catch (Exception e){
            return null;
        }

    }

    /**
     * 字符串时间转换为DateTime时间 字符串时间格式为yyyy-MM-dd
     * @param dateStr 字符串时间
     * @return
     */
    public static DateTime dateStr2DateTime(String dateStr){

        if(StringUtils.isBlank(dateStr)){
            return null;
        }
        return dateStr2DateTime(dateStr, DATE_FORMAT);

    }
    //------------------------------------------------------------------------------------------------------------------
    /**
     * 字符串时间 时间差 秒 字符串时间格式只能为 yyyy-MM-dd HH:mm:ss
     * @param startDateStr
     * @param endDateStr
     * @return
     */
    public static int secondsBetween(String startDateStr, String endDateStr){

        if (StringUtils.isBlank(startDateStr) || StringUtils.isBlank(endDateStr)) {
            return -1;
        }

        return secondsBetween(startDateStr, endDateStr, FULL_DATE_FORMAT);

    }

    /**
     * 字符串时间 时间差 秒 字符串时间格式需要指定
     * @param startDateStr 开始时间
     * @param endDateStr 结束时间
     * @param format 字符串时间格式
     * @return
     */
    public static int secondsBetween(String startDateStr, String endDateStr, String format) {

        if (StringUtils.isBlank(startDateStr) || StringUtils.isBlank(endDateStr) || StringUtils.isBlank(format)) {
            return -1;
        }

        DateTime startDate = dateStr2DateTime(startDateStr, format);
        if(Objects.equal(startDate, null)){
            return -1;
        }

        DateTime endDate = dateStr2DateTime(endDateStr, format);
        if(Objects.equal(endDate, format)){
            return -1;
        }

        return secondsBetween(startDate, endDate);

    }

    /**
     * DateTime 时间差 秒
     * @param startDate
     * @param endDate
     * @return
     */
    public static int secondsBetween(DateTime startDate, DateTime endDate) {

        if (Objects.equal(startDate, null) || Objects.equal(endDate, null)) {
            return -1;
        }

        try{
            int seconds = Seconds.secondsBetween(startDate, endDate).getSeconds();
            return seconds;
        }
        catch (Exception e){
            return -1;
        }

    }
    //------------------------------------------------------------------------------------------------------------------
    /**
     * 字符串时间 时间差 分钟 字符串时间格式只能为 yyyy-MM-dd HH:mm:ss
     * @param startDateStr
     * @param endDateStr
     * @return
     */
    public static int minutesBetween(String startDateStr, String endDateStr){

        if (StringUtils.isBlank(startDateStr) || StringUtils.isBlank(endDateStr)) {
            return -1;
        }

        return minutesBetween(startDateStr, endDateStr, FULL_DATE_FORMAT);

    }

    /**
     * 字符串时间 时间差 分钟 字符串时间格式需要指定
     * @param startDateStr 开始时间
     * @param endDateStr 结束时间
     * @param format 字符串时间格式
     * @return
     */
    public static int minutesBetween(String startDateStr, String endDateStr, String format) {

        if (StringUtils.isBlank(startDateStr) || StringUtils.isBlank(endDateStr) || StringUtils.isBlank(format)) {
            return -1;
        }

        DateTime startDate = dateStr2DateTime(startDateStr, format);
        if(Objects.equal(startDate, null)){
            return -1;
        }

        DateTime endDate = dateStr2DateTime(endDateStr, format);
        if(Objects.equal(endDate, format)){
            return -1;
        }

        return minutesBetween(startDate, endDate);

    }

    /**
     * DateTime 时间差 分钟
     * @param startDate
     * @param endDate
     * @return
     */
    public static int minutesBetween(DateTime startDate, DateTime endDate) {

        if (Objects.equal(startDate, null) || Objects.equal(endDate, null)) {
            return -1;
        }

        try{
            int minutes = Minutes.minutesBetween(startDate, endDate).getMinutes();
            return minutes;
        }
        catch (Exception e){
            return -1;
        }

    }

    //------------------------------------------------------------------------------------------------------------------
    /**
     * 字符串时间 时间差 小时 字符串时间格式只能为 yyyy-MM-dd HH:mm:ss
     * @param startDateStr
     * @param endDateStr
     * @return
     */
    public static int hoursBetween(String startDateStr, String endDateStr){

        if (StringUtils.isBlank(startDateStr) || StringUtils.isBlank(endDateStr)) {
            return -1;
        }

        return hoursBetween(startDateStr, endDateStr, FULL_DATE_FORMAT);

    }

    /**
     * 字符串时间 时间差 小时 字符串时间格式需要指定
     * @param startDateStr 开始时间
     * @param endDateStr 结束时间
     * @param format 字符串时间格式
     * @return
     */
    public static int hoursBetween(String startDateStr, String endDateStr, String format) {

        if (StringUtils.isBlank(startDateStr) || StringUtils.isBlank(endDateStr) || StringUtils.isBlank(format)) {
            return -1;
        }

        DateTime startDate = dateStr2DateTime(startDateStr, format);
        if(Objects.equal(startDate, null)){
            return -1;
        }

        DateTime endDate = dateStr2DateTime(endDateStr, format);
        if(Objects.equal(endDate, format)){
            return -1;
        }

        return hoursBetween(startDate, endDate);

    }

    /**
     * DateTime 时间差 小时
     * @param startDate
     * @param endDate
     * @return
     */
    public static int hoursBetween(DateTime startDate, DateTime endDate) {

        if (Objects.equal(startDate, null) || Objects.equal(endDate, null)) {
            return -1;
        }

        try{
            int hours = Hours.hoursBetween(startDate, endDate).getHours();
            return hours;
        }
        catch (Exception e){
            return -1;
        }

    }
    //------------------------------------------------------------------------------------------------------------------
    /**
     * 字符串时间 时间差 日 字符串时间格式只能为 yyyy-MM-dd
     * @param startDateStr
     * @param endDateStr
     * @return
     */
    public static String daysBetween(String startDateStr, String endDateStr){

        if (StringUtils.isBlank(startDateStr) || StringUtils.isBlank(endDateStr)) {
            return null;
        }

        return daysBetween(startDateStr, endDateStr, DATE_FORMAT);

    }

    /**
     * 字符串时间 时间差 日 字符串时间格式需要指定
     * @param startDateStr 开始时间
     * @param endDateStr 结束时间
     * @param format 字符串时间格式
     * @return
     */
    public static String daysBetween(String startDateStr, String endDateStr, String format) {

        if (StringUtils.isBlank(startDateStr) || StringUtils.isBlank(endDateStr) || StringUtils.isBlank(format)) {
            return null;
        }

        DateTime startDate = dateStr2DateTime(startDateStr, format);
        if(Objects.equal(startDate, null)){
            return null;
        }

        DateTime endDate = dateStr2DateTime(endDateStr, format);
        if(Objects.equal(endDate, format)){
            return null;
        }

        return daysBetween(startDate, endDate);

    }

    /**
     * DateTime 时间差 日
     * @param startDate
     * @param endDate
     * @return
     */
    public static String daysBetween(DateTime startDate, DateTime endDate) {

        if (Objects.equal(startDate, null) || Objects.equal(endDate, null)) {
            return null;
        }

        try{
            int days = Days.daysBetween(startDate, endDate).getDays();
            return Integer.toString(days);
        }
        catch (Exception e){
            return null;
        }

    }
    //------------------------------------------------------------------------------------------------------------------
    /**
     * 字符串时间 时间差 月 字符串时间格式只能为 yyyy-MM-dd
     * @param startDateStr
     * @param endDateStr
     * @return
     */
    public static int monthsBetween(String startDateStr, String endDateStr){

        if (StringUtils.isBlank(startDateStr) || StringUtils.isBlank(endDateStr)) {
            return -1;
        }

        return monthsBetween(startDateStr, endDateStr, DATE_FORMAT);

    }

    /**
     * 字符串时间 时间差 月 字符串时间格式需要指定
     * @param startDateStr 开始时间
     * @param endDateStr 结束时间
     * @param format 字符串时间格式
     * @return
     */
    public static int monthsBetween(String startDateStr, String endDateStr, String format) {

        if (StringUtils.isBlank(startDateStr) || StringUtils.isBlank(endDateStr) || StringUtils.isBlank(format)) {
            return -1;
        }

        DateTime startDate = dateStr2DateTime(startDateStr, format);
        if(Objects.equal(startDate, null)){
            return -1;
        }

        DateTime endDate = dateStr2DateTime(endDateStr, format);
        if(Objects.equal(endDate, format)){
            return -1;
        }

        return monthsBetween(startDate, endDate);

    }

    /**
     * DateTime 时间差 月
     * @param startDate
     * @param endDate
     * @return
     */
    public static int monthsBetween(DateTime startDate, DateTime endDate) {

        if (Objects.equal(startDate, null) || Objects.equal(endDate, null)) {
            return -1;
        }

        try{
            int months = Months.monthsBetween(startDate, endDate).getMonths();
            return months;
        }
        catch (Exception e){
            return -1;
        }

    }
    //------------------------------------------------------------------------------------------------------------------
    /**
     * 字符串时间 时间差 年 字符串时间格式只能为 yyyy-MM-dd
     * @param startDateStr
     * @param endDateStr
     * @return
     */
    public static int yearsBetween(String startDateStr, String endDateStr){

        if (StringUtils.isBlank(startDateStr) || StringUtils.isBlank(endDateStr)) {
            return -1;
        }

        return yearsBetween(startDateStr, endDateStr, DATE_FORMAT);

    }

    /**
     * 字符串时间 时间差 年 字符串时间格式需要指定
     * @param startDateStr 开始时间
     * @param endDateStr 结束时间
     * @param format 字符串时间格式
     * @return
     */
    public static int yearsBetween(String startDateStr, String endDateStr, String format) {

        if (StringUtils.isBlank(startDateStr) || StringUtils.isBlank(endDateStr) || StringUtils.isBlank(format)) {
            return -1;
        }

        DateTime startDate = dateStr2DateTime(startDateStr, format);
        if(Objects.equal(startDate, null)){
            return -1;
        }

        DateTime endDate = dateStr2DateTime(endDateStr, format);
        if(Objects.equal(endDate, format)){
            return -1;
        }

        return yearsBetween(startDate, endDate);

    }

    /**
     * DateTime 时间差 年
     * @param startDate
     * @param endDate
     * @return
     */
    public static int yearsBetween(DateTime startDate, DateTime endDate) {

        if (Objects.equal(startDate, null) || Objects.equal(endDate, null)) {
            return -1;
        }

        try{
            int years = Years.yearsBetween(startDate, endDate).getYears();
            return years;
        }
        catch (Exception e){
            return -1;
        }

    }
    //------------------------------------------------------------------------------------------------------------------
    /**
     * 字符串时间 时间差 日 小时 分钟 秒 字符串时间格式只能为 yyyy-MM-dd
     * @param startDateStr
     * @param endDateStr
     * @return
     */
    public static String dateTimeBetween(String startDateStr, String endDateStr){

        if (StringUtils.isBlank(startDateStr) || StringUtils.isBlank(endDateStr)) {
            return null;
        }

        return dateTimeBetween(startDateStr, endDateStr, FULL_DATE_FORMAT);

    }

    /**
     * 字符串时间 时间差 日 小时 分钟 秒 字符串时间格式需要指定
     * @param startDateStr 开始时间
     * @param endDateStr 结束时间
     * @param format 字符串时间格式
     * @return
     */
    public static String dateTimeBetween(String startDateStr, String endDateStr, String format) {

        if (StringUtils.isBlank(startDateStr) || StringUtils.isBlank(endDateStr) || StringUtils.isBlank(format)) {
            return null;
        }

        DateTime startDate = dateStr2DateTime(startDateStr, format);
        if(Objects.equal(startDate, null)){
            return null;
        }

        DateTime endDate = dateStr2DateTime(endDateStr, format);
        if(Objects.equal(endDate, format)){
            return null;
        }

        return dateTimeBetween(startDate, endDate);

    }

    /**
     * DateTime 时间差 日 小时 分钟 秒
     * @param startDate
     * @param endDate
     * @return
     */
    public static String dateTimeBetween(DateTime startDate, DateTime endDate) {

        if (Objects.equal(startDate, null) || Objects.equal(endDate, null)) {
            return null;
        }

        try{
            int days = Days.daysBetween(startDate, endDate).getDays();
            int hours = Hours.hoursBetween(startDate, endDate).getHours();
            int minutes = Minutes.minutesBetween(startDate, endDate).getMinutes();
            int seconds = Seconds.secondsBetween(startDate, endDate).getSeconds();
            String dates = days + "天" + hours % 24 + "小时" + minutes % 60 + "分钟" + seconds % 60 + "秒";
            return dates;
        }
        catch (Exception e){
            return null;
        }

    }
    //------------------------------------------------------------------------------------------------------------------
    /**
     * 字符串时间 格式化
     * @param dateStr
     * @param sourceFormat 字符串时间格式
     * @param targetFormat 格式化时间格式
     * @return
     */
    public static String dateStrFormat(String dateStr, String sourceFormat, String targetFormat) {

        if(StringUtils.isBlank(dateStr) || StringUtils.isBlank(sourceFormat) || StringUtils.isBlank(targetFormat)){
            return null;
        }

        DateTime dateTime = dateStr2DateTime(dateStr, sourceFormat);
        if(Objects.equal(dateTime, null)){
            return null;
        }

        try{
            return dateTime.toString(targetFormat);
        }
        catch (Exception e){
            return null;
        }

    }


    public static void main(String[] args) {
        String first_act_time = "NULL";
        String first_order_time = "2017-01-18";

        String days = daysBetween(first_act_time, first_order_time, "yyyy-MM-dd");
        System.out.println(days);

        String currentDate = getCurrentDate("yyyy-MM-dd HH:mm:ss");
        System.out.println(currentDate);
    }
}
