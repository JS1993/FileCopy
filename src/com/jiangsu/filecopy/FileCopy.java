package com.jiangsu.filecopy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileCopy {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = getFile();
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file.getName()));
		
		int b;
		while((b = bis.read()) != -1){
			bos.write(b);
		}
		
		bis.close();
		bos.close();
	}
	
	public static File getFile(){
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入一个文件路径:");
		
		while(true){
			String line = sc.nextLine();
			java.io.File file = new File(line);
			if(!file.exists()){
				System.out.println("您录入的文件路径不存在，请重新输入");
			}else if (file.isDirectory()){
				System.out.println("您输入的是文件夹路径，请重新输入");
			}else{
				return file;
			}
		}
	}

}
