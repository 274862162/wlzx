package cn.edu.gduf.netserver.domain;

/**
 * 交换机信息
 * @author cjy
 *
 */


public class Switch {
	
   private int switchID; //ID
	
   private int building;   //楼栋
   
   private int buildingNo; //楼层
   
   private String photo;   //图片
   
   private String switchRegister;   //交换机信息表
    
   
   public int getSwitchID() {
      return switchID;
   }
   
   
   public void setSwitchID(int newSwitchID) {
      switchID = newSwitchID;
   }
   
   
   
   
   
   public int getBuilding() {
	return building;
}


public void setBuilding(int building) {
	this.building = building;
}


public int getBuildingNo() {
	return buildingNo;
}


public void setBuildingNo(int buildingNo) {
	this.buildingNo = buildingNo;
}


public String getPhoto() {
      return photo;
   }
   
   
   public void setPhoto(String newPhoto) {
      photo = newPhoto;
   }
   
   
   public String getSwitchRegister() {
      return switchRegister;
   }
   
   
   public void setSwitchRegister(String newSwitchRegister) {
      switchRegister = newSwitchRegister;
   }
   

}