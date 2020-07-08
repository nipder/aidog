package com.sec.aidog.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sec.aidog.pojo.DevResource;
import com.sec.aidog.service.DevResourceService;
import com.sec.aidog.util.FileSysUtil;
import com.sec.aidog.util.IdUtil;
import com.sec.aidog.util.JSONUtil;
import com.sec.aidog.util.JsonResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RequestMapping("api")
@Controller
public class ResApi{
    @Autowired
    private DevResourceService devResourceService;

    @RequestMapping(value = "restest",produces = "application/json; charset=utf-8",method = RequestMethod.GET)
    @ResponseBody
    public String ResTestApi(){
        return "api res ctrl ok!";
    }

    @RequestMapping(value = "/uploadvideo", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<JsonResult>  uploadVideo(HttpServletRequest request,
                                 @RequestParam MultipartFile file,
                                 @RequestParam(required = false) String id,
                                 @RequestParam(required = false) Integer num,
                                 @RequestParam(required = false) String  ccid) throws IOException {
        JsonResult r = new JsonResult();

        try {
            String extentionName = FileSysUtil.getFileExt(file.getOriginalFilename());
            String resName = file.getOriginalFilename();
            byte[] fileData = file.getBytes();

            String fileName = IdUtil.generateRandomId("F") + "."
                + extentionName;

            String ResBaseDir = "d:/devvideo/";
            String sPath = ResBaseDir + id;
            FileSysUtil.CreateFolder(sPath);
            String sFilePath = sPath + "/" + fileName;

            String fileUrl = "https://www.nipder.com/videores/" + id + "/" + fileName;

            if(FileSysUtil.SaveResourceFile(sFilePath, fileData)){
                int row = devResourceService.addResourceForUpload(id, num, ccid, sFilePath, fileUrl, extentionName, resName);
                if(row>0){
                    r.setCode(200);
                    r.setMsg("文件上传成功!");
                    r.setSuccess(true);
                }
            }
        } catch (Exception ex) {
            r.setCode(500);
            r.setData(ex.getClass().getName() + ":" + ex.getMessage());
            r.setMsg("文件上传失败！");
            r.setSuccess(false);
            ex.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    @RequestMapping(value = "/getdevvideo", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<JsonResult> GetDevVideoList(@RequestParam(value = "mid",required = true)String mid, HttpServletRequest request){
        String token = request.getHeader("token");
        JsonResult r = new JsonResult();

        try {
            List<DevResource> list=null;
            list = devResourceService.getDevVideoResList(mid);

            r.setCode(200);
            r.setMsg("获取视频列表信息成功！");
            r.setData(list);
            r.setSuccess(true);
        } catch (Exception e) {
            r.setCode(500);
            r.setData(e.getClass().getName() + ":" + e.getMessage());
            r.setMsg("获取视频列表信息失败");
            r.setSuccess(false);
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }
}