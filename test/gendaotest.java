import com.novae.eswsplatform.bean.SystemTimeBean;
import com.novae.eswsplatform.dao.SystemTimeBeanDAO;



public class gendaotest {

	public static void main(String[] args) {
		SystemTimeBeanDAO dao = new SystemTimeBeanDAO();
		SystemTimeBean bean = new SystemTimeBean();
		bean = dao.findById(3);
		System.out.println(bean.getOpenTime());
		System.out.println(bean.getCloseTime());
	}

}
