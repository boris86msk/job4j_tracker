package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (User user : users)  {
            if (user.getUsername().equals(login)) {
                return user;
            }
        }
        throw new UserNotFoundException();
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
            User user = findUser(users, "Boris Pokidov");
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
