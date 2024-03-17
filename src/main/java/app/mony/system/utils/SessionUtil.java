package app.mony.system.utils;

import jakarta.servlet.http.HttpSession;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

public class SessionUtil {

    private static ConcurrentHashMap<String, CopyOnWriteArraySet<HttpSession>> logonSessionMap = null;
}
