package designPattern.pattern5.case1;

//具体原型类
public class Email implements Cloneable {
    private Attachment attachment = null;

    public Email() {
        this.attachment = new Attachment();
    }

    public Email(Attachment attachment) {
        super();
        this.attachment = attachment;
    }

    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

    public void disPlay() {
        System.out.println("查看邮件");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        Email clone = null;
        try {
            clone = (Email) super.clone();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return clone;
    }

}

class Attachment {
    public void download() {
        System.out.println("下载附件");
    }
}