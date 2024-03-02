package com.aditya;

import java.util.ArrayList;
import java.util.List;

public class MyStatefulSingleton {

    static MyStatefulSingleton _instance = new MyStatefulSingleton();
    private int i;

    public static MyStatefulSingleton getInstance() {
        return _instance;
    }

    List<ProfileDTO> profileDTOS = new ArrayList<>();

    public void increment(){i++;}
    public void decrement(){i--;}


    public void add(String method, long l) {
        if(l>0){
            profileDTOS.add(new ProfileDTO(this.i,method,l));
        }

        if(i==1){
            StringBuilder sb = new StringBuilder();
            for(int x=profileDTOS.size()-1;x>=0;x--){
                sb.append(profileDTOS.get(x).toString());
            }
            System.out.print(sb);
            profileDTOS.clear();
        }
    }
}
