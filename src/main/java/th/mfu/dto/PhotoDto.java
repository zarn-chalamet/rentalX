package th.mfu.dto;

public class PhotoDto {
    private byte[] imageData;
    private String fileName;
    private String mimeType;

    public PhotoDto() {
    }

    public PhotoDto(byte[] imageData, String fileName, String mimeType) {
        this.imageData = imageData;
        this.fileName = fileName;
        this.mimeType = mimeType;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }
}
