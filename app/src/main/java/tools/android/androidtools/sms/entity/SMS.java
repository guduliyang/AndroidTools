package tools.android.androidtools.sms.entity;

public class SMS {
    /**
     * thread_id : 对话的序号
     * address : 发件人地址，手机号
     * date : 日期 long型
     * read : 是否阅读
     * status : 状态
     * type :  类型 1是收到的，2是发出的
     * body : 内容
     * service_center : 信服务中心号码编号
     * MODEL : 手机型号
     */

    private String thread_id;
    private String address;
    private long date;
    private int read;   //已读：1   未读：0
    private int status;
    private int type;
    private String body;
    private String service_center;
    private int sub_id;
    private int sim_id;
    private String MODEL; //手机型号

    @Override
    public String toString() {
        return "SMS{" +
                "thread_id='" + thread_id + '\'' +
                ", address='" + address + '\'' +
                ", date=" + date +
                ", read=" + read +
                ", status=" + status +
                ", type=" + type +
                ", body='" + body + '\'' +
                ", service_center='" + service_center + '\'' +
                ", sub_id=" + sub_id +
                ", sim_id=" + sim_id +
                ", MODEL='" + MODEL + '\'' +
                '}';
    }

    public String getThread_id() {
        return thread_id;
    }

    public void setThread_id(String thread_id) {
        this.thread_id = thread_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public int getRead() {
        return read;
    }

    public void setRead(int read) {
        this.read = read;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getService_center() {
        return service_center;
    }

    public void setService_center(String service_center) {
        this.service_center = service_center;
    }

    public int getSub_id() {
        return sub_id;
    }

    public void setSub_id(int sub_id) {
        this.sub_id = sub_id;
    }

    public int getSim_id() {
        return sim_id;
    }

    public void setSim_id(int sim_id) {
        this.sim_id = sim_id;
    }

    public String getMODEL() {
        return MODEL;
    }

    public void setMODEL(String MODEL) {
        this.MODEL = MODEL;
    }
}
