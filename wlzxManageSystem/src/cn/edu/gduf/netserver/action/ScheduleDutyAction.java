package cn.edu.gduf.netserver.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import cn.edu.gduf.netserver.dao.IScheduleDao;
import cn.edu.gduf.netserver.dao.IUserDao;
import cn.edu.gduf.netserver.dao.impl.ScheduleDaoImpl;
import cn.edu.gduf.netserver.dao.impl.UserDaoImpl;
import cn.edu.gduf.netserver.domain.DutyTime;
import cn.edu.gduf.netserver.domain.Free;
import cn.edu.gduf.netserver.domain.User;
import cn.edu.gduf.netserver.util.ResponseUtil;

public class ScheduleDutyAction implements Action{

	/**
	 * 显示值班表
	 */
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		IUserDao userDao = new UserDaoImpl();
		IScheduleDao scheduleDao = new ScheduleDaoImpl();
		DutyTime mon12 = new DutyTime("mon12");  // 周一一二节值班段
		DutyTime mon345 = new DutyTime("mon345");
		DutyTime mon6789 = new DutyTime("mon6789");
		DutyTime tues12 = new DutyTime("tues12");
		DutyTime tues345 = new DutyTime("tues345");
		DutyTime tues6789 = new DutyTime("tues6789");
		DutyTime wed12 = new DutyTime("wed12");
		DutyTime wed345 = new DutyTime("wed345");
		DutyTime wed6789 = new DutyTime("wed6789");
		DutyTime thurs12 = new DutyTime("thurs12");
		DutyTime thurs345 = new DutyTime("thurs345");
		DutyTime thurs6789 = new DutyTime("thurs6789");
		DutyTime fri12 = new DutyTime("fri12");
		DutyTime fri345 = new DutyTime("fri345");
		DutyTime fri6789 = new DutyTime("fri6789");
		User user;
		String freeTableID = request.getParameter("freeTableID");  // 无课表id
		List<Integer> userFreeTableIDs = null;
		List<DutyTime> dutyTimeList = new ArrayList<DutyTime>();  // 前台显示用的
		List<DutyTime> newDutyTimeList = new ArrayList<DutyTime>();  // 排序安排值班用的
		try {
			userFreeTableIDs = scheduleDao.getUserFreeTableId(Integer.parseInt(freeTableID));
		} catch (Exception e) {
			e.printStackTrace();
		}
		Iterator<Integer> it = userFreeTableIDs.iterator();
		while (it.hasNext()) {
			Integer id = it.next();
			user = userDao.getUserById(scheduleDao.getUserFreeTableById(id).getUserID());  // 根据用户与无课表的关联id得到用户
			List<Free> frees = scheduleDao.getFrees(id);
			Iterator<Free> freesIt = frees.iterator();
			int freeNum = 0;  // 一周无课次数
			while (freesIt.hasNext()) {
				Free free = freesIt.next();
				if ("3".equals(free.getOnetwo())) {
					freeNum ++;
				}
				if ("3".equals(free.getThreefour())&&"3".equals(free.getFive())) {
					freeNum ++;
				}
				if ("3".equals(free.getSixseven())&&"3".equals(free.getEight())&&"3".equals(free.getNineten())) {
					freeNum ++;
				}
				
				// 星期一
				if (free.getWeekID()==1) {
					if ("3".equals(free.getOnetwo())) {
						mon12.getFreeUsers().add(user);
					}
					if ("3".equals(free.getThreefour())&&"3".equals(free.getFive())) {
						mon345.getFreeUsers().add(user);
					}
					if ("3".equals(free.getSixseven())&&"3".equals(free.getEight())&&"3".equals(free.getNineten())) {
						mon6789.getFreeUsers().add(user);
					}
				}
				// 星期二
				else if (free.getWeekID()==2) {
					if ("3".equals(free.getOnetwo())) {
						tues12.getFreeUsers().add(user);
					}
					if ("3".equals(free.getThreefour())&&"3".equals(free.getFive())) {
						tues345.getFreeUsers().add(user);
					}
					if ("3".equals(free.getSixseven())&&"3".equals(free.getEight())&&"3".equals(free.getNineten())) {
						tues6789.getFreeUsers().add(user);
					}
				}
				// 星期三
				else if (free.getWeekID()==3) {
					if ("3".equals(free.getOnetwo())) {
						wed12.getFreeUsers().add(user);
					}
					if ("3".equals(free.getThreefour())&&"3".equals(free.getFive())) {
						wed345.getFreeUsers().add(user);
					}
					if ("3".equals(free.getSixseven())&&"3".equals(free.getEight())&&"3".equals(free.getNineten())) {
						wed6789.getFreeUsers().add(user);
					}
				}
				// 星期四
				else if (free.getWeekID()==4) {
					if ("3".equals(free.getOnetwo())) {
						thurs12.getFreeUsers().add(user);
					}
					if ("3".equals(free.getThreefour())&&"3".equals(free.getFive())) {
						thurs345.getFreeUsers().add(user);
					}
					if ("3".equals(free.getSixseven())&&"3".equals(free.getEight())&&"3".equals(free.getNineten())) {
						thurs6789.getFreeUsers().add(user);
					}
				}
				// 星期五
				else if (free.getWeekID()==5) {
					if ("3".equals(free.getOnetwo())) {
						fri12.getFreeUsers().add(user);
					}
					if ("3".equals(free.getThreefour())&&"3".equals(free.getFive())) {
						fri345.getFreeUsers().add(user);
					}
					if ("3".equals(free.getSixseven())&&"3".equals(free.getEight())&&"3".equals(free.getNineten())) {
						fri6789.getFreeUsers().add(user);
					}
				}
			}
			user.setFreeNum(freeNum);
		}
		dutyTimeList.add(mon12);
		dutyTimeList.add(mon345);
		dutyTimeList.add(mon6789);
		dutyTimeList.add(tues12);
		dutyTimeList.add(tues345);
		dutyTimeList.add(tues6789);
		dutyTimeList.add(wed12);
		dutyTimeList.add(wed345);
		dutyTimeList.add(wed6789);
		dutyTimeList.add(thurs12);
		dutyTimeList.add(thurs345);
		dutyTimeList.add(thurs6789);
		dutyTimeList.add(fri12);
		dutyTimeList.add(fri345);
		dutyTimeList.add(fri6789);
		
		newDutyTimeList.add(mon12);
		newDutyTimeList.add(mon345);
		newDutyTimeList.add(mon6789);
		newDutyTimeList.add(tues12);
		newDutyTimeList.add(tues345);
		newDutyTimeList.add(tues6789);
		newDutyTimeList.add(wed12);
		newDutyTimeList.add(wed345);
		newDutyTimeList.add(wed6789);
		newDutyTimeList.add(thurs12);
		newDutyTimeList.add(thurs345);
		newDutyTimeList.add(thurs6789);
		newDutyTimeList.add(fri12);
		newDutyTimeList.add(fri345);
		newDutyTimeList.add(fri6789);
		
		/**
		 * 默认每个值班段两个人
		 */
		for (int w = 0; w < 3; w++) {
			// 排序，可用于值班的人数少的值班段排在前面，下面安排值班是可用于值班的人数少的值班段优先安排
			newDutyTimeList = dutyTimeSort(newDutyTimeList);
			
			// 遍历已排好序的值班段，为每个值班段安排值班人员
			for (int i = 0; i < newDutyTimeList.size(); i++) {
				// 如果该值班段有无课的人才安排值班
				if (newDutyTimeList.get(i).getFreeUsers().size() > 0) {
					// 得到的都是未被安排过值班的人，并排好序，总无课次数少的人排前面
					List<User> freeUserList = freeUserSort(newDutyTimeList.get(i).getFreeUsers());
					// 将可在该值班段值班的人安排到该值班段值班
					newDutyTimeList.get(i).getDutyUsers().add(freeUserList.get(0));
				//	System.out.println(freeUserList.get(0).getName() + " 被安排到" + newDutyTimeList.get(i).getTime() + "值班；该值班段现有"+newDutyTimeList.get(i).getDutyUsers().size()+"人值班，"+freeUserList.get(0).getName()+"一周总无课次数为："+freeUserList.get(0).getFreeNum());

					// 将被安排的人从各个值班段（有该人的值班段）中删除，下次不用再遍历
					User delUser = freeUserList.get(0);
					for (int j = 0; j < newDutyTimeList.size(); j++) {
						if (newDutyTimeList.get(j).getFreeUsers().contains(delUser)) {
							newDutyTimeList.get(j).getFreeUsers().remove(delUser);
						//	System.out.println("---"+delUser.getName()+"已从"+newDutyTimeList.get(j).getTime()+"值班段删除，目前该值班段剩余未被安排人数有："+newDutyTimeList.get(j).getFreeUsers().size());
						}
					}
				}else {
				//	System.out.println(newDutyTimeList.get(i).getTime()+"该值班段已无人可安排值班");
				}
			}
			
		//	System.out.println("---------------------安排了一轮--------------------");
		}
		
		JSONArray jsonArray = JSONArray.fromObject(dutyTimeList);
		try {
			ResponseUtil.write(jsonArray, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 对某一值班段中无课的人进行排序（一周总无课次数少的人排在前面）
	 * @param dutyTimeList
	 */
	public static List<User> freeUserSort(List<User> freeUserList){
        int n = freeUserList.size();

        for (int i = 0; i < n; i++)
        {
            int min = i;
            //从第i+1个元素开始，找最小值
            for (int j = i + 1; j < n; j++)
            {
                if (freeUserList.get(min).getFreeNum() > freeUserList.get(j).getFreeNum())
                    min = j;
            }
            if (min != i) {
            	//找到之后和第i个元素交换
            	swap(freeUserList, i, min);
			}
        }
		return freeUserList;
    }
	
	/**
	 * 对值班段排序（可用于值班的人数少的值班段排在前面）
	 * @param dutyTimeList
	 */
	public static List<DutyTime> dutyTimeSort(List<DutyTime> dutyTimeList){
        int n = dutyTimeList.size();

        for (int i = 0; i < n; i++)
        {
            int min = i;
            //从第i+1个元素开始，找最小值
            for (int j = i + 1; j < n; j++)
            {
                if (dutyTimeList.get(min).getFreeUsers().size() > dutyTimeList.get(j).getFreeUsers().size()){
                	min = j;
                }
            }
            if (min != i) {
            	//找到之后和第i个元素交换
            	swap(dutyTimeList, i, min);
			}
        }
		return dutyTimeList;
    }
	
	/**
	 * 交换集合中两个元素
	 * @param list
	 * @param i
	 * @param min
	 */
	private static <T> void swap(List<T> list, int i, int min){
        T temp = list.get(i);
        list.set(i, list.get(min));
        list.set(min, temp);
    }
}
