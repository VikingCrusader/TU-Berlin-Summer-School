package day2;

public class day2_review {
	public static void main(String[] args) {
		//Scanner mastered
		//Reading Args mastered
		double a1 = Double.parseDouble(args[0]);
		double a2 = Double.parseDouble(args[1]);
		System.out.println(a1+a2);

		//Math library pow sqrt random mastered
		//Bitwise opreations mastered 按位与/或/非
		
		//? : 运算符 现在还没太懂，周末搞懂
		//Integer.parseInt()字符串转int    Double.parseDouble()字符串转double
		String ss = "1011";
//		ss = (int)ss;
		int ssi = Integer.parseInt(ss);
		System.out.println(ssi+1);
		
		//String opreates
		//1.connection of strings via "+"
		
		//2.chararray to string 字符数组转化为字符串
		/* We can copy a char array to a string by using
         * copyValueOf() method */
		char ch[] = {'M','y',' ','J','a','v','a',' ','e','x','a','m','p','l','e'};
        String s0 = String.copyValueOf(ch);
        System.out.println(s0);
        
        //3.length
        String s1 = "Ich liebe Deutschland, besonders Berlin.";
        System.out.println(s1.length());
        
        //4.substring 子字符串，顾名思义
        String s2 = s1.substring(0,21);
        System.out.println(s2);
        
        //5.boolean contains 判断一个字符串是否包括另一个字符或单词等
        if(s1.contains("Deutschland")) {
        	System.out.println("Ja");
        }else {
        	System.out.println("Nein");
        }
        
        //6.boolean startwith 判断一个字符串是不是起始字符为xxx
        if(s1.startsWith("Ich")) {
        	System.out.println("Super");
        }
        
        //7.boolean endwith 和上一个同理
        if(s1.endsWith("Berlin.")) {
        	System.out.println("genau");
        }
        
        //8.indexOf 某个字符的出现位置 默认(first)indexOf 如果说明确说最后一个，就用lastindexOf，indexOf(String, int)明确第几个index
        System.out.println(s1.indexOf("D"));
        System.out.println(s1.lastIndexOf("e"));
        
        //9.concat 后面append另一个字符串
        System.out.println(s1.concat(" Und auch Hamburg."));
        
        //10.compareTo() 比较另一个字符串
        System.out.println(s1.compareTo("Ich liebe dich")); //比较两个字符串的字典排序，从第一个字母开始，一个一个比谁“字典序”更靠前，如果一样就继续比下一个，直到有不同，谁的字母小谁排前。
        
        //11.replace()把某一部分换成一个新的部分
        String s3 = "110111 Berlin";
        String s4 = s3.replace("0", "2");
        System.out.println(s4);

        String str = "a1b2c3";
        String result = str.replaceAll("[0-9]", "");
        System.out.println(result); // 输出 abc

        //12. boolean equals 判断字符串是不是相等
        String s5 = "aaa";
        String s6 = "bbb";
        String s7 = "aaa";
        System.out.println(s5.equals(s7));
        System.out.println(s5.equals(s6));

        //13. split（） 切割数组 Java 中 split() 是 String 类的一个方法，用来按照指定的分隔符把字符串切成一个字符串数组
        String s8 = "Orange,Rabbit,iPhone,Paris";
        String arr1[] = s8.split(",");
        for(String obj : arr1) {
        	System.out.println(obj);
        } //遍历数组元素
        
        //补充一点 字符数组和字符串数组的区别，char和String，字符数组只允许存储一位字符，字符串数组可以存放字符串
        
        // 课件里就这些，更多的后面再补充！
        // 字符串的Exercises留到周末
        

	}
}
