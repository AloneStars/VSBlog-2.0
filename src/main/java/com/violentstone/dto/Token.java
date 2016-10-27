package com.violentstone.dto;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Token {
	
	String[] Token=new String[]{"0","1","2","3","4","5","6","7","8","9"};
	
	public String randToken(){
		String token="";
		for(int i=0;i<6;i++){
			Random rand=new Random();
			int s=rand.nextInt(10);
			token=token+Token[s];
		}		
		return token;
	}
	
	
	public static void main(String[] args) {
		Token token=new Token();
		System.out.println(token.randToken());
	}

}
