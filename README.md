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

4、log simple -- set custom tag  
Log.d("TAG","test");  
Log.v("TAG","test");  
Log.i("TAG","test");  
Log.w("TAG","test");  
Log.e("TAG","test");  

5、log advance  
Log.d("test",new Throwable("test"));  
Log.v("test",new Throwable("test"));  
Log.i("test",new Throwable("test"));  
Log.w("test",new Throwable("test"));  
Log.e("test",new Throwable("test"));  

6、log advance  -- set custom tag   
Log.d("TAG","test",new Throwable("test"));  
Log.v("TAG","test",new Throwable("test"));  
Log.i("TAG","test",new Throwable("test"));  
Log.w("TAG","test",new Throwable("test"));  
Log.e("TAG","test",new Throwable("test"));  

