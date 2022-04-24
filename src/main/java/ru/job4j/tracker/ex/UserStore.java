package ru.job4j.tracker.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        int index = -1;
        for (int i = 0; i < users.length; i++)  {
            if (users[i].getUsername().equals(login)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new UserNotFoundException();
        }
        return users[index];
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException();
        }
        return user.isValid();
    }

    public static void main(String[] args) {
        try {
            User[] users = {
                    new User("Boris Pokidov", true)
            };
            User user = findUser(users, "Boris Pokido");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException unf) {
            unf.printStackTrace();
        } catch (UserNotFoundException ui) {
            ui.printStackTrace();
        }
    }
}
