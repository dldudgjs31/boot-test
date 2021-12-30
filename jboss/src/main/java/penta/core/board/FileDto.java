package penta.core.board;


public class FileDto {
	public String uuid;
	public String fileName;
	public String contentType;
	

	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
	public FileDto() {}
	
	
	public FileDto(String uuid, String fileName, String contentType) {
		this.uuid =uuid;
		this.fileName=fileName;
		this.contentType=contentType;
		System.out.println(contentType);
	}
}
