package db;

public class SQLString {
	public static String construct(String[] content) {
		String str="";
		for(int i=0;i<content.length;i++) {
			if(i==0)
				str+=content[i];
			else
				str+=","+content[i];
		}
		return str;
	}
	
	public static String insertColumn(String[] content) {
		String str="(";
		for(int i=0;i<content.length;i++) {
			if(i==0)
				str+=content[i];
			else
				str+=","+content[i];
		}
		str+=")";
		return str;
	}
	
	public static String insertValues(String[] content) {
		String str="(";
		for(int i=0;i<content.length;i++) {
			if(i==0)
				str+="\""+content[i]+"\"";
			else
				str+=","+"\""+content[i]+"\"";
		}
		str+=")";
		return str;
	}
}
