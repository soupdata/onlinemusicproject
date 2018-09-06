package com.online.tools.hadoop;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.compress.utils.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;
import org.junit.jupiter.api.Test;
import org.testng.annotations.BeforeClass;

public class HdfsUtils {
    private static FileSystem fs;
    /**
     * 每次测试前都将进入此方法对fs进行初始化
     * @throws Exception
     */
    @BeforeClass
    public  void init()throws Exception{
        Configuration conf=new Configuration();
        /**
         设置配置文件（hdfs-site.xml，core-site.xml文件）的信息，
         也可以将工作目录下的core-site.xml,hdfs-site.xml文件
         添加到src目录下，如果不填加程序运行时会报错，
         因为程序的默认的文件管理系统是本地的文件管理系统而不是
         hdfs。
         下面的设置相当于告诉程序，我们的配置是作用在hdfs（分布式文件系统）上的，
         这个设置将会覆盖scr目录下hdfs-site.xml中的相应属性的配置
         通过这个配置生成的fs实际上继承了抽象类FileSystem的DistributedFileSystem子类。
         */
        conf.set("fs.defaultFS", "hdfs://localhost:9000");
        fs = FileSystem.get(conf);
        System.out.println("执行init方法");
    }
    /**
     * 上传文件到hdfs上（没有被封装）
     * @throws Exception
     */
    @Test
    public void upload() throws Exception{

        Path path=new Path("hdfs://localhost:9000/sfd/sfd3.txt");
        //从文件系统中的到输出流
        FSDataOutputStream os=fs.create(path);
        //得到客户端本地的输入流
        FileInputStream in=new FileInputStream("/home/sfd/soft/download/sfd1.txt");
        //将上面得到的输入流中的数据通过工具类复制到输出流中，从而实现文件从本地上传到hdfs的过程
        IOUtils.copy(in, os);

    }
    /**
     * 使用框架实现本地文件的上传
     * @throws Exception
     */
    @Test
    public void upload2(String localpath,String hdfspath) throws Exception{
        System.out.println("执行upload2方法");
        fs.copyFromLocalFile(new Path(localpath), new Path(hdfspath));
        System.out.println("文件put到hdfs成功");
    }
    /**
     * 使用框架下载hdfs中的文件到本地
     * @throws Exception
     */
    @Test
    public void download(String hdfspath,String localpath)throws Exception{
        //"hdfs://localhost:9000/aa/bb/sfd3.txt" "/home/sfd/soft/download/sfd4.txt"
        fs.copyToLocalFile(new Path(hdfspath), new Path(localpath));
        System.out.println(hdfspath+"上传到本地"+localpath+"成功！");

    }
    /**
     * 查询文件目录中的所有文件（包括子文件夹下的文件，不包括文件夹）
     * @throws Exception
     */
    @Test
    public void listFile()throws Exception{
        //得到hdfs指定（第一个参数）目录下的文件状态的迭代器,第二个参数表示是否迭代的取出该目录下文件夹下的子文件
        RemoteIterator< LocatedFileStatus> files=fs.listFiles(new Path("/"), false);
        //遍历迭代器得到文件名
        while (files.hasNext()){
            //分别得到每个文件的状态
            LocatedFileStatus file=files.next();
            //从状态中得到文件的路径，进而得到文件名
            Path path=file.getPath();
            String filename=path.getName();
            //输出文件名
            System.out.println(filename);

        }

    }
    /**
     * 查询指定目录下的文件和文件夹
     * @throws Exception
     */
    @Test
    public void listFindAndDir(String dirctory)throws Exception{
        //得到文件的状态"/"
        FileStatus[] listStatus = fs.listStatus(new Path(dirctory));
        //遍历
        for (FileStatus fileStatus:listStatus){
            Path path = fileStatus.getPath();
            String name = path.getName();
            System.out.println(name);
        }
    }
    /**
     * 在hdfs中创建文件夹
     * @throws Exception
     */
    @Test
    public void makedir()throws Exception{
        //如果bb文件夹没有就先创建bb文件夹，如果aa还没有就先创建cc文件夹
        fs.mkdirs(new Path("/aa/bb/cc"));
    }
    /**
     * 使用框架删除文件或非空文件夹
     * @throws Exception
     */
    @Test
    public void remove(String filenameORdirectory,boolean flag)throws Exception{
        //true默认不递归删除
        //删除目录，第二个参数便是是否递归删除，如果第一个参数表示的是非空的文件夹，就会报错
        fs.delete(new Path(filenameORdirectory), flag);
        System.out.println("删除"+filenameORdirectory+"成功！");
    }
    /**
     * 使用框架实现文件的重命名和移动
     * @throws Exception
     */
    @Test
    public void reName()throws Exception{
        //1.当两个参数所指向的文件在一个文件夹下的时候实现的是重命名
        //2.当两个参数所指向的文件在不同文件夹下的时候实现的是移动文件
        fs.rename(new Path("/sfd/sfd1.txt"),new Path("/sfd/sfd4.txt"));
    }
}
