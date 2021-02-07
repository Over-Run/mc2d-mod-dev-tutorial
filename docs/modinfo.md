# 模组信息

在添加方块前，我们先大致了解一个Minecraft2D Mod项目的结构。

```
src
  main
    java
      com.examplemod
        ExampleMod - 入口点
    resources
      mc2d.mod.prop - 模组属性
```

其中mc2d.mod.prop是必不可少的。如果缺少了，Minecraft2D ModLoader会跳过加载。

## mc2d.mod.prop

下面列出该属性文件的内容：

| 键      | 值         | 默认值      |
| ------- | ---------- | ----------- |
| modid   | 你的Mod ID | （无）      |
| main    | 模组入口点 | （无）      |
| name    | 模组名     | 模组的modid |
| version | 模组版本   | 0.0.0       |

<div class="admonition note">
<p class=admonition-title>Note</p>
<p>ModID并不限制大小写。理论上可以包含任何字符。</p>
</div>

无默认值的属性如果缺少则会导致无法启动。

下面是一个例子：

```properties
# The modid
modid=examplemod
# The mod main entrypoint
main=com.examplemod.ExampleMod
# The mod name (Optional)
name=Example Mod
# The mod version (Optional)
version=1.0.0
```

我们可以注意到，这个`main`指向一个类。这个类实现了`io.github.overrun.mc2d.mod.ModInitializer`。

```java
package com.examplemod;

import io.github.overrun.mc2d.mod.ModInitializer;

/**
 * @author squid233
 * @since 2021/02/07
 */
public final class ExampleMod implements ModInitializer {
    @Override
    public void onInitialize() {
        // Write your code
    }
}

```

<div class="admonition note">
<p class=admonition-title>Note</p>
<p>模组的入口点必须实现<code style=color:#458;>ModInitializer</code>。否则会导致ClassCastException。</p>
</div>


## 公共字段

公共字段可供其它类使用。这些字段会在模组初始化时自动填充。

<div class="admonition note">
<p class=admonition-title>Note</p>
<p>这些字段必须为<code style=color:#CC7832;>public</code>的。否则ModLoader将无法获取。</p>
<p>这些字段可以是<code style=color:#CC7832;>static</code>或非<code style=color:#CC7832;>static</code>的。</p>
</div>


为了方便，我们使用一个字段来储存ModID，以便后面使用。

```java
@Mod.Modid
public static String modid;
```

可以看到我们用了一个`Mod.Modid`注解。加上这个注解后该字段便会自动填充为你的ModID。

---

一切都准备好后，我们就可以开始添加一个方块了。