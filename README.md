# changebook-log
### 日志

### pom.xml
```
<dependency>
  <groupId>io.github.changebooks</groupId>
  <artifactId>changebook-log</artifactId>
  <version>1.0.1</version>
</dependency>
```

### 初始化日志频道
```
@Value("${spring.application.name}")
private String appName;

// %X{name}
LogName.set(appName);
```

### 初始化追溯id
```
// %X{tid}
LogTraceId.init();
```

### 初始化日志id
```
// %X{id}
LogId.init();
```

### 新增索引
```
// %X{index}
LogIndex.put(userId);
LogIndex.put(tenantId);
```

### 清空上下文
```
LogClear.clear();
```

### Pattern
```
"time": "%date{ISO8601}",
"level": "%level",
"name": "%X{name}",
"id": "%X{id}",
"pid": "%X{pid}",
"tid": "%X{tid}",
"index": "%X{index}",
"m": "%m",
"ex": "%ex",
"host": "${hostName}",
"thread": "%thread"
```
