package app.mony.system.interceptor.auth;

import lombok.Getter;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
public enum Auth {
    SEL(0,"SEL"),
    INS(1,"INS"),
    UPD(2,"UPD"),
    DEL(3,"DEL"),
    UPL(4,"UPL"),
    PRC(5,"PRC");

    private final int tranIdx;
    private final String tranCode;

    Auth(int tranIdx, String tranCode) {
        this.tranIdx = tranIdx;
        this.tranCode = tranCode;
    }

    private static final Map<String, Integer> map = Collections.unmodifiableMap(Stream.of(values()
            ).collect(Collectors.toMap(Auth::getTranCode,Auth::getTranIdx)));

    public static int find(String tranCode){
        return Optional.ofNullable(map.get(tranCode)).orElse(null);
    }


}
