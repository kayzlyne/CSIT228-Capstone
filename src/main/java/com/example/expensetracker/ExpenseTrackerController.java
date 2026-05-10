package com.example.expensetracker;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class ExpenseTrackerController {
    private final Map<String, ExpenseTrackerUser> accounts = new LinkedHashMap<>();
    private ExpenseTrackerUser currentUser;

    @FXML
    private VBox loginPane;

    @FXML
    private VBox registerPane;

    @FXML
    private VBox dashboardPane;

    @FXML
    private VBox dashboardHomePane;

    @FXML
    private VBox editProfilePane;

    @FXML
    private TextField loginNameField;

    @FXML
    private PasswordField loginPasswordField;

    @FXML
    private Label loginMessageLabel;

    @FXML
    private TextField registerFullNameField;

    @FXML
    private PasswordField registerPasswordField;

    @FXML
    private PasswordField registerConfirmPasswordField;

    @FXML
    private Label registerMessageLabel;

    @FXML
    private MenuButton profileMenuButton;

    @FXML
    private TextField editFullNameField;

    @FXML
    private PasswordField editCurrentPasswordField;

    @FXML
    private PasswordField editNewPasswordField;

    @FXML
    private PasswordField editConfirmPasswordField;

    @FXML
    private Label editProfileMessageLabel;

    @FXML
    private void initialize() {
        bindManagedToVisible(loginPane, registerPane, dashboardPane, dashboardHomePane, editProfilePane);
        showLoginPane();
        showDashboardSection(dashboardHomePane);
    }

    @FXML
    private void handleLogin() {
        clearMessages();

        String fullName = normalize(loginNameField.getText());
        String password = normalize(loginPasswordField.getText());

        if (fullName.isEmpty() || password.isEmpty()) {
            setErrorMessage(loginMessageLabel, "Enter your name and password.");
            return;
        }

        ExpenseTrackerUser account = accounts.get(accountKeyFor(fullName));
        if (account == null || !account.getPassword().equals(password)) {
            setErrorMessage(loginMessageLabel, "Account not found. Register first or check your login.");
            return;
        }

        currentUser = account;
        loginPasswordField.clear();
        refreshDashboard();
        showDashboardHome();
    }

    @FXML
    private void handleRegister() {
        clearMessages();

        String fullName = normalize(registerFullNameField.getText());
        String password = normalize(registerPasswordField.getText());
        String confirmPassword = normalize(registerConfirmPasswordField.getText());

        if (fullName.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            setErrorMessage(registerMessageLabel, "Complete all fields before creating the account.");
            return;
        }

        if (!password.equals(confirmPassword)) {
            setErrorMessage(registerMessageLabel, "Passwords do not match.");
            return;
        }

        String accountKey = accountKeyFor(fullName);
        if (accounts.containsKey(accountKey)) {
            setErrorMessage(registerMessageLabel, "That name is already in use.");
            return;
        }

        ExpenseTrackerUser account = new ExpenseTrackerUser(fullName, password);
        accounts.put(accountKey, account);
        currentUser = account;

        clearRegisterFields();
        refreshDashboard();
        showDashboardHome();
    }

    @FXML
    private void handleSaveProfile() {
        if (currentUser == null) {
            return;
        }

        clearMessages();

        String fullName = normalize(editFullNameField.getText());
        String currentPassword = normalize(editCurrentPasswordField.getText());
        String newPassword = normalize(editNewPasswordField.getText());
        String confirmPassword = normalize(editConfirmPasswordField.getText());

        if (fullName.isEmpty()) {
            setErrorMessage(editProfileMessageLabel, "Name cannot be empty.");
            return;
        }

        boolean changingPassword = !currentPassword.isEmpty() || !newPassword.isEmpty() || !confirmPassword.isEmpty();
        if (changingPassword) {
            if (currentPassword.isEmpty() || newPassword.isEmpty() || confirmPassword.isEmpty()) {
                setErrorMessage(editProfileMessageLabel, "Complete all password fields to change the password.");
                return;
            }

            if (!currentUser.getPassword().equals(currentPassword)) {
                setErrorMessage(editProfileMessageLabel, "Current password is incorrect.");
                return;
            }

            if (!newPassword.equals(confirmPassword)) {
                setErrorMessage(editProfileMessageLabel, "New password and confirm password do not match.");
                return;
            }
        }

        String oldKey = accountKeyFor(currentUser.getFullName());
        String newKey = accountKeyFor(fullName);

        if (!oldKey.equals(newKey) && accounts.containsKey(newKey)) {
            setErrorMessage(editProfileMessageLabel, "That name is already in use.");
            return;
        }

        accounts.remove(oldKey);
        currentUser.setFullName(fullName);
        if (changingPassword) {
            currentUser.setPassword(newPassword);
        }
        accounts.put(newKey, currentUser);

        refreshDashboard();
        clearEditPasswordFields();
        setSuccessMessage(editProfileMessageLabel, changingPassword ? "Profile and password updated." : "Profile updated.");
    }

    @FXML
    private void showRegisterPane() {
        clearMessages();
        showMainPane(registerPane);
    }

    @FXML
    private void showLoginPane() {
        clearMessages();
        showMainPane(loginPane);
    }

    @FXML
    private void showDashboardHome() {
        if (currentUser == null) {
            return;
        }

        refreshDashboard();
        showMainPane(dashboardPane);
        showDashboardSection(dashboardHomePane);
    }

    @FXML
    private void showEditProfilePane() {
        if (currentUser == null) {
            return;
        }

        editFullNameField.setText(currentUser.getFullName());
        clearEditPasswordFields();
        editProfileMessageLabel.setText("");

        showMainPane(dashboardPane);
        showDashboardSection(editProfilePane);
    }

    @FXML
    private void handleLogout() {
        currentUser = null;
        loginNameField.clear();
        loginPasswordField.clear();
        showLoginPane();
    }

    private void refreshDashboard() {
        if (currentUser == null) {
            return;
        }

        profileMenuButton.setText(firstNameOf(currentUser.getFullName()));
        editFullNameField.setText(currentUser.getFullName());
    }

    private String firstNameOf(String fullName) {
        String trimmedName = normalize(fullName);
        if (trimmedName.isEmpty()) {
            return "Profile";
        }

        int firstSpace = trimmedName.indexOf(' ');
        return firstSpace > 0 ? trimmedName.substring(0, firstSpace) : trimmedName;
    }

    private void showMainPane(Region targetPane) {
        loginPane.setVisible(targetPane == loginPane);
        registerPane.setVisible(targetPane == registerPane);
        dashboardPane.setVisible(targetPane == dashboardPane);
    }

    private void showDashboardSection(Region targetSection) {
        dashboardHomePane.setVisible(targetSection == dashboardHomePane);
        editProfilePane.setVisible(targetSection == editProfilePane);
    }

    private void clearMessages() {
        loginMessageLabel.setText("");
        registerMessageLabel.setText("");
        editProfileMessageLabel.setText("");

        resetMessageStyle(loginMessageLabel);
        resetMessageStyle(registerMessageLabel);
        resetMessageStyle(editProfileMessageLabel);
    }

    private void clearRegisterFields() {
        registerFullNameField.clear();
        registerPasswordField.clear();
        registerConfirmPasswordField.clear();
    }

    private void clearEditPasswordFields() {
        editCurrentPasswordField.clear();
        editNewPasswordField.clear();
        editConfirmPasswordField.clear();
    }

    private void bindManagedToVisible(Region... regions) {
        for (Region region : regions) {
            region.managedProperty().bind(region.visibleProperty());
        }
    }

    private String normalize(String value) {
        return value == null ? "" : value.trim();
    }

    private String accountKeyFor(String fullName) {
        return normalize(fullName).toLowerCase(Locale.ROOT);
    }

    private void setErrorMessage(Label label, String message) {
        label.setStyle("-fx-text-fill: #b91c1c;");
        label.setText(message);
    }

    private void setSuccessMessage(Label label, String message) {
        label.setStyle("-fx-text-fill: #0f766e;");
        label.setText(message);
    }

    private void resetMessageStyle(Label label) {
        label.setStyle("");
    }
}
