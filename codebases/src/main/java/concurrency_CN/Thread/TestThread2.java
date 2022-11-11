package concurrency_CN.Thread;

/**
 *  https://www.bilibili.com/video/BV1V4411p7EF?p=4&vd_source=333bb18bd89bdbb4a7c9b3b16c3947f3
 *
 *  1. download `commons-io-2.6.jar` from google
 *  2. add a folder `lib` into `main` folder
 *  3. right click => `add as library`
 */
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

//实现多线程同步下载图片
public class TestThread2 extends Thread{
    private String url; // 网络图片地址
    private String name;// 保存的文件名

    public TestThread2(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        ImageDownloader imageDownloader = new ImageDownloader();
        imageDownloader.downloader(url, name);
        System.out.println("The downloaded file's name is: " + name);
    }

    public static void main(String[] args) {
        TestThread2 t1 = new TestThread2("https://thisquarterly.sg/wp-content/uploads/2019/05/Under-The-Sea-thumb.jpg", "1.jpg");
        TestThread2 t2 = new TestThread2("https://helpx.adobe.com/content/dam/help/en/photoshop/using/convert-color-image-black-white/jcr_content/main-pars/before_and_after/image-before/Landscape-Color.jpg", "2.jpg");
        TestThread2 t3 = new TestThread2("https://pbs.twimg.com/media/E9MTrMZWQAYmNfi.jpg", "3.jpg");

        t1.start();
        t2.start();
        t3.start();
    }
}

class ImageDownloader {
    //download method
    public void downloader(String url, String name){
        try {
            //传递通过网络地址，生成一个文件
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO Exception, downloaded exception");
        }
    }
}



