package com.bogle.weixin;

import com.bogle.Application;
import com.bogle.weixin.defines.ActionName;
import com.bogle.weixin.domain.Channel;
import com.bogle.weixin.exception.WeixinException;
import com.bogle.weixin.message.ticket.ReqTicket;
import com.bogle.weixin.repository.ChannelRepository;
import com.bogle.weixin.service.IWxApi;
import com.bogle.weixin.tools.MatrixToImageWriter;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by Bogle on 2015/12/9.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = Application.class)
public class QrTest {

    @Autowired
    private ChannelRepository channelRepository;

    @Autowired
    private IWxApi wxApi;

//    @Test
    public void createQrById() throws WeixinException {
        Channel channel = channelRepository.findById(236);
        ReqTicket reqTicket = new ReqTicket(ActionName.QR_LIMIT_STR_SCENE, channel.getCode());
        reqTicket.setSceneName(channel.getName());
        byte[] bytes = this.wxApi.getQrcode(reqTicket);
        pringln(bytes, channel.getName() + "-" + channel.getCode());
    }

//    @Test
    public void createQrByIdBetween() throws WeixinException {
        List<Channel> channelList = channelRepository.findByIdBetween(234,235);
        for(Channel channel : channelList) {
            ReqTicket reqTicket = new ReqTicket(ActionName.QR_LIMIT_STR_SCENE, channel.getCode());
            reqTicket.setSceneName(channel.getName());
            byte[] bytes = this.wxApi.getQrcode(reqTicket);
            pringln(bytes, channel.getName() + "-" + channel.getCode());
        }
    }

    private void pringln(byte[] bytes, String name) {
        File file = new File("D:\\" + name + ".jpg");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(bytes);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 二维码url生成工具
     *
     * @param text
     * @param fileName
     * @throws IOException
     * @throws WriterException
     */
    public void createUrlQr(String text, String fileName) throws IOException, WriterException {
        int width = 1000;
        int height = 1000;
        //二维码的图片格式
        String format = "png";
        Hashtable hints = new Hashtable();
        //内容所使用编码
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, hints);
        //生成二维码
        File outputFile = new File("d:" + File.separator + "url" + File.separator + fileName + ".png");
        MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);
    }
}
