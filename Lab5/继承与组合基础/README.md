# 继承与组合基础
## Question 1
[Name.java](/继承与组合基础/src/main/java/Name.java)
## Question 2
[Person.java](/继承与组合基础/src/main/java/Person.java)
## Question 3
(1)可以访问
主函数：![alt text](/继承与组合基础/imgs/3-1.png)
输出：![alt text](/继承与组合基础/imgs/3-1输出.png)
(2)不能访问，因为Name中数据成员是private访问控制
(3)改变之后就可以访问name的数据成员，因为在同一个package里name成员是package access，可以访问
(4)会变化，在不同包里就不能访问了
## Question 4
[Student.java](/Lab5/继承与组合基础/src/main/java/Student.java)
## Question 5
[Teacheer.java](/Lab5/继承与组合基础/src/main/java/Teacher.java)
## Question 6
[test6.java](/Lab5/继承与组合基础/src/main/java/test6.java)
输出结果：
![alt text](/Lab5/继承与组合基础/imgs/6-输出.png)
输出结果都不同，因为多态，Person可以充当不同子类的对象，调用不同的talk()方法
## Question 7
[test7.java](/Lab5/继承与组合基础/src/main/java/test7.java)
输出结果：
![alt text](/Lab5/继承与组合基础/imgs/7-输出.png)
因为Student类中重写的talk()函数不带参数，p.talk("Math")中有参数所以会调用父类中继承的含参数的talk函数
## Question 8
[PersonFactory.java](/Lab5/继承与组合基础/src/main/java/PersonFactory.java)
数组是让copliot帮忙生成的
## Question 9
[Discussion.java](/Lab5/继承与组合基础/src/main/java/Discussion.java)
## Question 10

