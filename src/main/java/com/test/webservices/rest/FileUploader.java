package com.test.webservices.rest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

@Path("/upload")
public class FileUploader {
	
	@POST
	@Path("/file")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response upload(@FormDataParam("file") InputStream fileInputStream,
			@FormDataParam("file") FormDataContentDisposition fileMetaData)throws Exception{
		String uploadPath = "F:/Files/";
		try{
			int read = 0;
			byte[] bytes = new byte[1024];

			File file = new File(uploadPath+fileMetaData.getFileName());
			OutputStream out = new FileOutputStream(file);
			while((read = fileInputStream.read(bytes)) != -1){
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
		}catch(IOException e){
			throw new WebApplicationException("Error while Uploading file..."
					+" try Again.");
		}
		return Response.ok("Data upload succesfully !!").build();
	}
}

