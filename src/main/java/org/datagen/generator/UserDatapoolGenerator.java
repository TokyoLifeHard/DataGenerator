package org.datagen.generator;

import org.datagen.enitiy.User;
import org.datagen.io.Writer;

import java.io.IOException;

public class UserDatapoolGenerator {
    UserGenerator userGenerator;
    Writer writer;

    public UserDatapoolGenerator(UserGenerator userGenerator, Writer writer) {
        this.userGenerator = userGenerator;
        this.writer = writer;
    }

    public void genearteUser() throws IOException {
        User user = this.userGenerator.generateUser();
        this.writer.writeUser(user);
    }

    public void generateUsers(int count) throws IOException {
        for (int i = 0; i < count; i++) {
            genearteUser();
        }
    }
}
