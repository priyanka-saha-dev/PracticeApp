package threads;

import java.io.*;

public class TransientExample {

    public static void main(String[] args) {
        User user = new User("john_doe", "secure_password");

        // Serialize the user object
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("resources/user.ser"))) {
            oos.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize the user object
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("resources/user.ser"))) {
            User deserializedUser = (User) ois.readObject();
            System.out.println(deserializedUser); // Output: threads.User{username='john_doe', password='null'}
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
