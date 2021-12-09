package com.study.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

//    @Autowired
//    private DocumentConverter converter;

    @RequestMapping("/hello")
    public String helloWorld() {
        return "Hello World!";
    }

//    @RequestMapping("/preview")
//    public void preview() throws Exception {
//        final String path = "C:\\Users\\欲霸不能\\Desktop\\财务失真度数据格式\\fqr\\";
//        final String file = "fqr_indexes.docx";
//        InputStream input = new FileInputStream(path + file);
//        HWPFDocument wordDocument = new HWPFDocument(input);
//        WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(
//                DocumentBuilderFactory.newInstance().newDocumentBuilder()
//                        .newDocument());
//        wordToHtmlConverter.setPicturesManager(new PicturesManager() {
//            @Override
//            public String savePicture(byte[] bytes, PictureType pictureType, String s, float v, float v1) {
//                return s;
//            }
//        });
//        wordToHtmlConverter.processDocument(wordDocument);
//        List pics = wordDocument.getPicturesTable().getAllPictures();
//        if (pics != null) {
//            for (int i = 0; i < pics.size(); i++) {
//                Picture pic = (Picture) pics.get(i);
//                try {
//                    pic.writeImageContent(new FileOutputStream(path + pic.suggestFullFileName()));
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        Document htmlDocument = wordToHtmlConverter.getDocument();
//        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
//        DOMSource domSource = new DOMSource(htmlDocument);
//        StreamResult streamResult = new StreamResult(outStream);
//        TransformerFactory tf = TransformerFactory.newInstance();
//        Transformer serializer = tf.newTransformer();
//        serializer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
//        serializer.setOutputProperty(OutputKeys.INDENT, "yes");
//        serializer.setOutputProperty(OutputKeys.METHOD, "html");
//        serializer.transform(domSource, streamResult);
//        outStream.close();
//        String content = new String(outStream.toByteArray());
//        FileUtils.writeStringToFile(new File(path, "fqr_indexes.html"), content, "utf-8");
//    }

//    @RequestMapping("/preview")
//    public void preview(HttpServletResponse response) {
//        //需要转换的文件
//        File file = new File("C:\\Users\\欲霸不能\\Desktop\\财务失真度数据格式\\fqr\\fqr_indexes.docx");
//        File htmlFile = new File("C:\\Users\\欲霸不能\\Desktop\\财务失真度数据格式\\fqr\\1.html");
//        try {
//            //转换之后文件生成的地址
//            File newFile = new File("C:\\Users\\欲霸不能\\Desktop");
//            if (!newFile.exists()) {
//                newFile.mkdirs();
//            }
//
//            //文件转化
//            converter.convert(file).to(htmlFile).execute();
//            //使用response,将pdf文件以流的方式发送的前段
//            ServletOutputStream outputStream = response.getOutputStream();
//            // 读取文件
//            InputStream in = new FileInputStream(htmlFile);
//            // copy文件
//            int i = IOUtils.copy(in, outputStream);
//            System.out.println(i);
//            in.close();
//            outputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            htmlFile.delete();
//        }
//    }

//    @RequestMapping("/preview")
//    public void preview() throws IOException, IOException {
//
//        File docInputFile = new File("C:\\Users\\欲霸不能\\Desktop\\财务失真度数据格式\\fqr\\fqr_indexes.docx");
//        File htmlOutputFile = new File("C:\\Users\\欲霸不能\\Desktop\\1.html");
//        if (htmlOutputFile.exists()) {
//            htmlOutputFile.delete();
//            htmlOutputFile.createNewFile();
//        }
//
//        OpenOfficeConnection connection = new SocketOpenOfficeConnection(8100);
//        try {
//            connection.connect();
//        } catch (ConnectException e) {
//            System.err.println("文件转换出错，请检查OpenOffice服务是否启动。");
//        }
//        // convert
//        DocumentConverter converter = (DocumentConverter) new OpenOfficeDocumentConverter(connection);
//        converter.convert(docInputFile, htmlOutputFile);
//        connection.disconnect();
//        // 转换完之后删除word文件
//        docInputFile.delete();
//        return htmFileName;
//    }
}
