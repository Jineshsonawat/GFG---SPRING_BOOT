package com.learning.sb.model;


import lombok.*;


// These are all comes from Lombok dependency. It provides getter, setter etc.

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@With
public class Food {

    private int id;
    private String name;

//    This whole this is @builder. Only annotation will do the work

//    public static Builder builder(){
//        return new Builder();
//    }
//    public static class Builder{
//        private int id;
//        private String name;
//
//        public Builder id(int id){
//            this.id = id;
//            return this;
//        }
//
//        public Builder name(String name){
//            this.name = name;
//            return this;
//        }
//
//        public Food build(){
//            return new Food(this.id, this.name);
//        }
//    }

}
