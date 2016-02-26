package cn.edu.gduf.netserver.domain;

import java.util.Date;

/**
 * 用户类
 * @author cjy
 *
 */
public class User {

	public String getInterests() {
		return interests;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


	private int userID;	//ID

	private String userName;	//用户名

	private String password;	//登陆密码
	 
	private String sno;	//学号

	private String name;	//用户姓名

	private String sex;	//性别

	private int age;	//年龄

	private String major;	//专业

	private String dormitory;	//宿舍

	private String longTelephone;	//长号

	private String shortTelephone;	//短号

	private String section;	//部门
	
	private String repArea; //负责区域
	private String interests;	//兴趣爱好
	private String role;	//角色
	
	private String dutyTime;//值班时间
	
	private Date birth;	// /出生日期
	
	private int freeNum; // 一周无课次数（没映射到数据库
   
	public User() {
		super();
	}

    public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
   public String getDutyTime() {
		return dutyTime;
	}


	public void setDutyTime(String dutyTime) {
		this.dutyTime = dutyTime;
	}


public int getUserID() {
      return userID;
   }
   
  
   public void setUserID(int newUserID) {
      userID = newUserID;
   }
   
  
   public String getUserName() {
      return userName;
   }
   
   
   public void setUserName(String newUserName) {
      userName = newUserName;
   }
   
   
   public String getPassword() {
      return password;
   }
   
   
   public void setPassword(String newPassword) {
      password = newPassword;
   }
   
   
   public String getSno() {
      return sno;
   }
   
   
   public void setSno(String newSno) {
      sno = newSno;
   }
   
   
   public String getName() {
      return name;
   }
   
  
   public void setName(String newName) {
      name = newName;
   }
   
   
   public String getSex() {
      return sex;
   }
   
   
   public void setSex(String newSex) {
      sex = newSex;
   }
   
  
   public int getAge() {
      return age;
   }
   
   
   public void setAge(int newAge) {
      age = newAge;
   }
   
  
   public String getMajor() {
      return major;
   }
   
  
   public void setMajor(String newMajor) {
      major = newMajor;
   }
   

   public String getDormitory() {
      return dormitory;
   }
   
   
   public void setDormitory(String newDormitory) {
      dormitory = newDormitory;
   }
   
  
   public String getLongTelephone() {
      return longTelephone;
   }
   
   
   public void setLongTelephone(String newLongTelephone) {
      longTelephone = newLongTelephone;
   }
   
   
   public String getShortTelephone() {
      return shortTelephone;
   }
   
   
   public void setShortTelephone(String newShortTelephone) {
      shortTelephone = newShortTelephone;
   }
   
 
   public String getSection() {
      return section;
   }
   

   public void setSection(String newSection) {
      section = newSection;
   }

	
	public String getRepArea() {
		return repArea;
	}
	
	
	public void setRepArea(String repArea) {
		this.repArea = repArea;
	}


	public Date getBirth() {
		return birth;
	}


	public void setBirth(Date birth) {
		this.birth = birth;
	}


	public int getFreeNum() {
		return freeNum;
	}


	public void setFreeNum(int freeNum) {
		this.freeNum = freeNum;
	}
   
   
}