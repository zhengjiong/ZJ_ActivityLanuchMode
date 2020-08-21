# Activity Launch Mode 总结

- **FLAG_ACTIVITY_SINGLE_TOP**

  1.启动其他Activity，单独使用是没有任何效果的，必须和Intent.FLAG_ACTIVITY_CLEAR_TOP配合使用。

  2.如果是自己启动自己，单独使用有效果，会直接执行自身的onNewIntent方法。

- **FLAG_ACTIVITY_CLEAR_TOP单独使用**

  效果是对目标activity之上的全部清空,然后自己也onDestroy，并重新启动一个自己。

- **FLAG_ACTIVITY_CLEAR_TOP 和 FLAG_ACTIVITY_SINGLE_TOP 一起使用**

  会查找栈中是否已经存在目标activity,如果存在则直接跳转到目标activity(并不会onDestroy和onCreate),并清空目标activity之上的所有activity，如果不存在则创建并清空之上的所有activity。

- **FLAG_ACTIVITY_CLEAR_TASK和FLAG_ACTIVITY_NEW_TASK一起使用**

  将会导致任何用来放置该activity的已经存在的task里面的已经存在的activity先清空，然后该activity再在该task中启动，也就是说，这个新启动的activity变为了这个空task的根activity.所有老的activity都结束掉。

  

  未完待续...

