package dev.flappyBird.util;

import static org.lwjgl.opengl.GL11.GL_FALSE;
import static org.lwjgl.opengl.GL20.*;

/**
 * Created by NewLease on 26/08/2014.
 */
public class ShaderUtils {
    private ShaderUtils(){}

    public static int load(String vertPath, String fragPath){
        String vert = FileUtils.loadAsString(vertPath);
        String frag = FileUtils.loadAsString(fragPath);

        return create(vert, frag);
    }

    public static int create(String vert, String frag){
        int programId = glCreateProgram();
        int vertId = glCreateShader(GL_VERTEX_SHADER);
        int fragId = glCreateShader(GL_FRAGMENT_SHADER);

        glShaderSource(vertId, vert);
        glShaderSource(fragId, frag);

        glCompileShader(vertId);
        if(glGetShaderi(vertId, GL_COMPILE_STATUS) == GL_FALSE){
            System.err.println("Failed to compile vertex shader!");
            System.err.println(glGetShaderInfoLog(vertId, 2048));
        }

        glCompileShader(fragId);
        if(glGetShaderi(fragId, GL_COMPILE_STATUS) == GL_FALSE){
            System.err.println("Failed to compile fragment shader!");
            System.err.println(glGetShaderInfoLog(fragId, 2048));
        }

        glAttachShader(programId, vertId);
        glAttachShader(programId, fragId);

        glLinkProgram(programId);

        glValidateProgram(programId);

        return programId;
    }
}
