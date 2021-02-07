# 添加一个方块

添加一个方块非常简单。只需在`onInitialize`方法中加入一条语句即可。

```java
Registry.register(Registry.BLOCK, "examplemod:example_block", new Block());
```

当然，由于Minecraft2D目前还没有像Minecraft的`setblock`指令，因此，我们将上面那条语句修改一下：

```java
Registry.register(Registry.ITEM, "examplemod:example_block", new BlockItem(Registry.register(Registry.BLOCK, "examplemod:example_block", new Block())));
```

这样可以同时注册方块与物品。

为了避免把ModID写错，我们使用之前那个`modid`。

```java
Registry.register(Registry.ITEM, new Identifier(modid, "example_block"), new BlockItem(Registry.register(Registry.BLOCK, new Identifier(modid, "example_block"), new Block())));
```

<!--看着挺长的。-->

现在方块写好了。只需要将模组像平常打包成jar即可（无需将依赖库打包）。

在成功启动后，您应该会在创造模式物品栏中看到一个紫黑块，并在控制台中看到一个NPE。

## 添加材质

要添加材质，需要一个png文件。该png文件放在`assets/modid/textures/block`下。

对于我们上面添加的方块，需要像下面一样放置：

```
assets
  examplemod
    textures
      block
        example_block.png
```

方块的材质可以参考原版的。