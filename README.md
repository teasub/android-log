android-log
===========

android lib - log  

1、enable/disable log  
Log.setEnabled(true);  
Log.setEnabled(false);  

2、set the Tag for the log  
Log.setTag("Android");  

3、log simple  
Log.d("test");  
Log.v("test");  
Log.i("test");  
Log.w("test");  
Log.e("test");  

4、log advance  
Log.d("test",new Throwable("test"));  
Log.v("test",new Throwable("test"));  
Log.i("test",new Throwable("test"));  
Log.w("test",new Throwable("test"));  
Log.e("test",new Throwable("test"));  


