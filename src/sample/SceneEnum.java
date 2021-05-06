package sample;

public enum SceneEnum {
    SCENE_LOGIN,SCENE_CHAT,SCENE_REGISTER,SCENE_FRIENDS,SCENE_PROFILE_EDIT,SCENE_MAIN;
    public static String getResource(SceneEnum scene) {
        switch (scene) {
            case SCENE_LOGIN:
                return "./view/login.fxml";
            case SCENE_CHAT:
               return "./view/login.fxml";
            case SCENE_REGISTER:
                return "./view/register.fxml";
            case SCENE_FRIENDS:
                return "./view/friends.fxml";
            case SCENE_PROFILE_EDIT:
                return "./view/profileEdit.fxml";
            case SCENE_MAIN:
                return "./view/main.fxml";
            default:
                return "./view/main.fxml";
        }
    }
}
