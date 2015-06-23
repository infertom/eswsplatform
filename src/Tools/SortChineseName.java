package Tools;

import java.text.Collator;
import java.util.Comparator;

import com.novae.eswsplatform.bean.DeclarerBean;

public class SortChineseName implements Comparator<DeclarerBean> {
	Collator cmp = Collator.getInstance(java.util.Locale.CHINA);  
    @Override  
    public int compare(DeclarerBean o1, DeclarerBean o2) {  
        if (cmp.compare(o1.getName(), o2.getName())>0){  
            return 1;  
        }else if (cmp.compare(o1.getName(), o2.getName())<0){  
            return -1;  
        }  
        return 0;  
    }
}
