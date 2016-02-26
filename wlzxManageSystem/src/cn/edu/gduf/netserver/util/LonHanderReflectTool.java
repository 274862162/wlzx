package cn.edu.gduf.netserver.util;

import java.lang.reflect.*;

//设计用来反射代理类，因为动态生成的代理类没有声明所在包（是默认包），所以要去掉获得所在包信息，
//自定义的类如果没有package语句，也是没有声明包（也是默认包），用反射也获取不了包名

public class LonHanderReflectTool {

	//反射整个类
	public static void ReflectClass(String className){
		try{
			//获取类对象
			Class c=Class.forName(className);
			
			//打印所在包
			//printPackage(c); //因为动态生成的代理类没有声明所在包（是默认包），所以要去掉获得所在包信息
			
			//打印类声明、继承父类、所实现的接口
			 printClassSuperClassInterface(c);
		    
		    //打印成员变量
		    printAllFields(c);
		    
		    System.out.println();
		    
		    //打印构造方法
		    printAllConstructor(c);
		    
		    System.out.println();
		    
		    //打印其他方法
		    printAllmenthods(c);
		    
		    
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	//打印类声明、继承父类、所实现的接口
	public static void printClassSuperClassInterface(Class c){
       //打印类修饰符
		System.out.print(Modifier.toString(c.getModifiers())+" ");
		
		//打印类名
		System.out.print("class "+c.getSimpleName());
	    
		//获取类的父类
		Class superClass=c.getSuperclass();
		
		//打印 "extends" 关键字
		System.out.print(" extends ");
		
		//打印父类名
	    System.out.print(superClass.getSimpleName());
	    
       //打印"implements"关键字
	    System.out.print(" implements ");
	    
	    //获取实现接口数组
	    Class []is=c.getInterfaces();
	    for(int i=0;i<is.length;i++){
	    	//打印接口名字
	    	System.out.print(is[i].getSimpleName());
	    	
	    	//如果不是打印到最后一个参数就打印一个逗号分隔
			if(i<is.length-1){
				System.out.print(",");
			}
	    }
	    //打印左大括号
	    System.out.println("{");
	}
	
	//打印所在包
	public static void printPackage(Class c){
		//获取包名
		Package p=c.getPackage();
		
		//打印"packgage"关键字
		System.out.print("package ");
		
		//打印包名
		System.out.print(p.getName());
		
		//打印包名最后的分号
		System.out.println(";");
	}
	
	//打印所有成员变量
	public static void printAllFields(Class c){
		//获取成员变量数组
		Field []fi=c.getDeclaredFields();
		for(Field f:fi){
			//打印每个成员变量的修饰符
			System.out.print(" "+Modifier.toString(f.getModifiers())+" ");
			
			//获取每个成员变量的类型
			Class c2=f.getType();
			
			//打印每个成员变量的类型
			System.out.print(c2.getSimpleName()+" ");
			
			//打印每个成员变量的变量名
			System.out.print(f.getName());
			
			//打印每个成员变量最后的分号
			System.out.println(";");
			
		}
	}
	
	//打印所有的构造方法
	public static void printAllConstructor(Class cz){
		//获取构造方法数组
		Constructor[]cs=cz.getConstructors();
		for(Constructor c:cs){
			//打印构造方法的修饰符
			System.out.print(" "+Modifier.toString(c.getModifiers())+" ");
			
			//打印构造方法的方法名
			System.out.print(cz.getSimpleName());
			
            //也是打印构造方法的方法名，（全限定名）
		  //System.out.print(c.getName());  // 因为是全限定名，所以不用这个方法
			
			//打印构造方法参数列表的左括号
			System.out.print("(");
			
			//获取构造方法里面的参数类型数组
			Class[] ps=c.getParameterTypes();
			
			//打印构造方法里面的参数类型
			for(int i=0;i<ps.length;i++){
				System.out.print(ps[i].getSimpleName());
				System.out.print(" arg"+i);
				
			//如果不是打印到最后一个参数就打印一个逗号分隔
				if(i<ps.length-1){
					System.out.print(",");
				}
			}//打印构造方法里面的参数的for循环的结尾
			
			//打印构造方法参数的右括号
			System.out.print(")");
			
			//获取方法中的异常类数组
			Class[] exceptions=c.getExceptionTypes();
			
			//打印"throws"关键字
			if(exceptions.length!=0){
				System.out.print(" throws ");
			}
			//打印异常类型
			for(int i=0;i<exceptions.length;i++){
				System.out.print(exceptions[i].getSimpleName());
				
				//如果不是打印到最后一个异常就打印一个逗号分隔
				if(i<exceptions.length-1){
					System.out.print(",");
				}
			}
			System.out.println("{}");
		}//foreach循环结尾
	}
	
	//打印其他方法
	public static void printAllmenthods(Class cz){
		//获取方法数组
		//Method[]ms=cz.getMethods(); 这个只能获取共有的方法
		Method[]ms=cz.getDeclaredMethods();//不管私有、公有、保护类型的方法都获取
		for(Method m:ms){
			
            //打印方法的修饰符
			System.out.print(Modifier.toString(m.getModifiers())+" ");
		
			//获取泛型方法的类型数组
			TypeVariable[]yvs=m.getTypeParameters();
			
			//如果该方法定义为了泛型方法
			if(yvs.length!=0){
			
			//打印泛型左尖括号"<"
			System.out.print(" <");
			for(TypeVariable yv:yvs){
				
				//打印泛型定义标识符
				System.out.print(yv.getName());
			}
            //打印泛型右尖括号">"
			System.out.print("> ");
			}
			
			//获取方法返回类型
			Type ts=m.getGenericReturnType();
			
			//如果返回类型有泛型标识符E或者T
			if(ts.toString().charAt(0)=='E'||ts.toString().charAt(0)=='T'){
				//打印泛型返回类型标识符
				 System.out.print(ts.toString());
			//没有的话，打印普通的返回类型
			}else{
			//获取方法返回类型
            Class mt=m.getReturnType();			
            //打印方法返回类型
            System.out.print(" "+mt.getSimpleName());
            
			}
            //打印方法名
            System.out.print(" "+m.getName());
            
            //打印方法参数列表的左括号
            System.out.print("(");
            
           //获取方法参数类型数组（包含泛型）
            Type [] gms=m.getGenericParameterTypes();
            
            
            if(gms.length!=0){
                for(int i=0;i<gms.length;i++){
                	//打印方法参数类型
                	if(gms.toString().startsWith("E")||gms.toString().startsWith("T")){
                		System.out.print(gms[i]);
                		//打印方法参数名
                		System.out.print(" args"+i);
                	}else{
                		//如果不是泛型则取全限定名最后一个点后面的类名
                		//获取最后一个点的位置
                    	int lastPoint=gms[i].toString().lastIndexOf('.');
                    	//获取最后一个点后面的类的名字
                    	String ClassSimpleName=gms[i].toString().substring(lastPoint+1);
                    	System.out.print(ClassSimpleName);
                    	//打印方法参数名
                    	System.out.print(" args"+i);
                	}
                	//如果不是打印到最后一个参数就打印一个逗号分隔
                	if(i<gms.length-1){
                		System.out.print(",");
                	}
                }
            }
            //打印方法参数列表右括号
            System.out.print(")");
            
            //获取方法异常类型数组
            Class[] exceptions=m.getExceptionTypes();
            
            //打印"throws"关键字
            if(exceptions.length!=0){
            	System.out.print("throws");
            }
            
            //打印方法异常类型
            for(int i=0;i<exceptions.length;i++){
            	System.out.print(" "+exceptions[i].getSimpleName());
            }
            
            //打印方法方法体大括号
            System.out.println("{}");
		}
		
	}
	
}
