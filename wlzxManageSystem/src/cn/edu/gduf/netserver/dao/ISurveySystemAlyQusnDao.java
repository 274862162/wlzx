package cn.edu.gduf.netserver.dao;

import java.util.ArrayList;

import cn.edu.gduf.netserver.domain.Findings;
import cn.edu.gduf.netserver.domain.QusnnList;

public interface ISurveySystemAlyQusnDao {
	/**根据问卷ID查询问卷信息
	 * @param qusnID
	 * @return
	 */
	public QusnnList queryQusn(int qusnID);
	/**根据问卷ID查询问题选择结果
	 * @param qusnID 问卷ID
	 * @return 问题选择的结果集
	 */
	public ArrayList<Findings> queryQuesFindings(int qusnID);
}
