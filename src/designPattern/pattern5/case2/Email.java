package designPattern.pattern5.case2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//因为是实现的Serializable接口，所以可以不用重写clone()
public class Email implements Serializable {
    /**
     * serializeID
     */
    private static final long serialVersionUID = 1L;
    private Attachment attachment = null;

    public Email() {
        super();
        this.attachment = new Attachment();
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

    public Object deepClone() throws IOException {
        // 将对象写入
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(this);

        // 取出
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        return objectInputStream;
    }
}

class Attachment {
    public void download() {
        System.out.println("下载附件");
    }
}