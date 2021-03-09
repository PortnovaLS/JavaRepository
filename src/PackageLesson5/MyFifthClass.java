package PackageLesson5;

public class MyFifthClass {

    public static void main (String[] args){

        Dog dog = new Dog(500, 10,0.5);
        Horse horse = new Horse(1500,100,3);
        Bird bird = new Bird(5, 0,0.2);
        Cat cat = new Cat(200,0,2);
        Dog dog1 = new Dog();
        Horse horse1 = new Horse ();
        Bird bird1 = new Bird();
        Cat cat1 = new Cat();

        dog.run(400);
        horse.run(1400);
        bird.run(4);
        cat.run(150);
        bird.swim(0);
        cat.swim(0);
        dog1.run(1000);
        horse1.swim(35);
        bird1.run(50);
        cat1.jump(8.2);


    }

}
