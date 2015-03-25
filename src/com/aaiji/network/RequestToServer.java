package com.aaiji.network;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;

import android.text.TextUtils;
import android.util.Log;

import com.aaiji.listener.OnDataReceived;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.google.gson.Gson;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParsePush;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

public class RequestToServer<T> extends Request<T> {
	
	
	public RequestToServer(int method, String url, ErrorListener listener) {
		super(method, url, listener);
		// TODO Auto-generated constructor stub
	}


	public final static int REQUEST_GROUP_DATA =17;
	public final static int REGISTER_USER =18;
	public final static int GET_USER =19;
	//public final static int REGISTER_USER_GROUP =20;
	public final static int GET_GROUP_MESSAGE =21;
	public final static int POST_GROUP_MESSAGE =22;
	public final static int GET_MY_DETAILS =23;
	public final static int POST_MESSAGE_STATUS =24;
	
	
	
	
	
	public static String COLUMN_MESSAGE = "mMessage";
	public static String COLUMN_MESSAGE_MORE = "mLink";
	public static String COLUMN_MESSAGE_LIKE = "mLike";
	public static String COLUMN_MESSAGE_ID = "mId";
	
	
	
	//public final static String GROUP_CLASS = "Group";// make it uniform, since group is keyword in sql
	public final static String GROUP = "Group_class"; // make it uniform
	public final static String GROUP_PARENT = "mParent";
	public final static String GROUP_TITLE = "mTitle";
	public final static String GROUP_IMAGE_URL = "mURL";
	public final static String GROUP_INFO_CLASS = "group_info_class";
	
	private final static String USER_CLASS = "mUser";
	private final static String USER_NAME = "mUserName";
	private final static String USER_PHONE = "mUserPhone";
	private final static String USER_LOCATION = "mUserLocation";
	private final static String USER_GROUP_LIST = "mUsersGroup";
	private final static String USER_ADMIN = "mAdmin";
	
	public final static String MESSAGE_CLASS_NAME = "mUser";
	public final static String MESSAGE_SENT_BY = "mSenderName";
	public final static String MESSAGE_TEXT = "mMessageText";
	public final static String MESSAGE_PIC_URL = "mMessagePicUrl";
	public final static String MESSAGE_MP3_URL = "mMessagemp3Url";
	public final static String MESSAGE_VID_URL = "mMessagevidUrl";
	public final static String MESSAGE_ID = "objectId";
	public final static String MESSAGE_APPROVE_STATUS = "mMessageStatus";
	
	
	private static RequestToServer requestToserver ;//= new RequestToServer();
	
	
	
//	public static RequestToServer getInstance( ) {
//		if(requestToserver == null){
//			requestToserver = new RequestToServer();
//		}
//	      return requestToserver;
//	   }
	
	
	public synchronized void makeGetRequest(int request, Object callback, Object filter){
				
		switch(request){
		
		case REQUEST_GROUP_DATA:
			 //getGroupList((OnDataReceived)callback,(String)filter);
			 break;
		case GET_USER:
			 //getUser((OnDataReceived)callback);
			 break;
		case GET_MY_DETAILS:
			 //getMyDetail((OnDataReceived)callback);
			 break;
		
		}
		
	}


	@Override
	protected void deliverResponse(T arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected Response<T> parseNetworkResponse(NetworkResponse arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	private void getGroupMessages(final String groupName,final OnDataReceived callback) {
//		// TODO Auto-generated method stub
//		ParseQuery<ParseObject> query = ParseQuery.getQuery(groupName);		
//		query.whereEqualTo(MESSAGE_APPROVE_STATUS, true);
//		query.findInBackground(new FindCallback<ParseObject>() {
//			@Override
//			public void done(List<ParseObject> messageObject, ParseException e) {
//				// TODO Auto-generated method stub
//				if (e == null && messageObject.size() > 0) {
//					//already registered
//					//callback.onSuccess();
//					int k = messageObject.size();
//					//LinkedHashMap<String, ArrayList<VendorDataModel>> vendorCategories = new LinkedHashMap<String, ArrayList<VendorDataModel>>();
//					
//					for(int i=0;i<k;i++){
//						MessageDataModel mModel = new MessageDataModel();
//						mModel.setMessageGroupName(groupName);
//						mModel.setMessageVid(messageObject.get(i).getString(MESSAGE_VID_URL));
//						mModel.setMessageText(messageObject.get(i).getString(MESSAGE_TEXT));
//						mModel.setSenderName(messageObject.get(i).getString(MESSAGE_SENT_BY));
//						mModel.setMessageMp3(messageObject.get(i).getString(MESSAGE_MP3_URL));
//						mModel.setMessagePic(messageObject.get(i).getString(MESSAGE_PIC_URL));
//						mModel.setMessageId(messageObject.get(i).getObjectId());
//						Date date = messageObject.get(i).getCreatedAt();
//						mModel.setDate(date.toString());
//						mModel.setApprove(messageObject.get(i).getBoolean(MESSAGE_APPROVE_STATUS));
//						callback.onDataReceived(mModel);
//						
//					}
//					
//				}/*else if(messageObject.size() == 0){
//					
//					ParseObject customer = new ParseObject(groupName);					
//					customer.put(MESSAGE_SENT_BY, user.getName());
//					customer.put(MESSAGE_TEXT, user.getPhonenumber());
//					customer.put(MESSAGE_PIC_URL, user.getAddress());
//					customer.put(MESSAGE_MP3_URL, user.getAddress());
//					customer.put(MESSAGE_VID_URL, user.getAddress());
//
//								
//				}*/else{
//					//callback.onFailure();
//				}
//			}
//		});
//	}
//	
//	private void getUser(final OnDataReceived callback) {
//		// TODO Auto-generated method stub
//		ParseQuery<ParseObject> query = ParseQuery.getQuery(USER_CLASS);
//		if(!ReceiverApplication.IS_USER_ADMIN){
//			query.whereEqualTo(USER_ADMIN,true);
//		}
//		query.findInBackground(new FindCallback<ParseObject>() {
//			@Override
//			public void done(List<ParseObject> userObject, ParseException e) {
//				// TODO Auto-generated method stub
//				if (e == null && userObject.size() > 0) {
//					NeighbourDataSource cDataSource = new NeighbourDataSource(ReceiverApplication.getAppContext());
//					cDataSource.open();					
//					for(int i=0;i<userObject.size();i++){
//						User user = new User();
//						user.setName(ifEmpty(userObject.get(i).getString(USER_NAME)));
//						user.setAddress(ifEmpty(userObject.get(i).getString(USER_LOCATION)));
//						user.setPhonenumber(ifEmpty(userObject.get(i).getString(USER_PHONE)));
//						//user.setAdmin(userObject.get(i).getBoolean(USER_ADMIN));
//						//user.setGroup(ifEmpty(userObject.get(i).getString(USER_GROUP_LIST)));
//						cDataSource.createCustomer(user);
//						
//					}
//					
//					callback.onDataReceived(null);
//					
//				}else{
//					callback.onDataReceivedError(e.getMessage());
//				}
//			}
//		 });
//		
//	}
//	
//	private void getMyDetail(final OnDataReceived callback) {
//		// TODO Auto-generated method stub
//		ParseQuery<ParseObject> query = ParseQuery.getQuery(USER_CLASS);
//		query.whereContains(USER_NAME,ReceiverApplication.USER_NAME);
//		query.findInBackground(new FindCallback<ParseObject>() {
//			@Override
//			public void done(List<ParseObject> userObject, ParseException e) {
//				// TODO Auto-generated method stub
//				if (e == null && userObject.size() > 0) {					
//					ReceiverApplication.IS_USER_ADMIN = userObject.get(0).getBoolean(USER_ADMIN);
//					callback.onDataReceived(null);
//					
//				}else{
//					callback.onDataReceivedError(e.getMessage());
//				}
//			}
//		 });
//		
//	}
//	
//	private void getGroupList(final OnDataReceived callback,String groupParent) {
//		// TODO Auto-generated method stub
//		ParseQuery<ParseObject> query = ParseQuery.getQuery(GROUP);
//		//query.whereContains(GROUP_PARENT,groupParent);
//		query.findInBackground(new FindCallback<ParseObject>() {
//			@Override
//			public void done(final List<ParseObject> groupObject, ParseException e) {
//				// TODO Auto-generated method stub
//				if (e == null && groupObject.size() > 0) {
//					
//					int k = groupObject.size();
//					for(int i=0;i<k;i++){
//						final String groupName = groupObject.get(i).getString(GROUP_TITLE);
//						final String groupIcon = groupObject.get(i).getString(GROUP_IMAGE_URL);
//						//ParseQuery<ParseObject> query = ParseQuery.getQuery(USER_CLASS);
//						//query.whereEqualTo(USER_NAME,ReceiverApplication.USER_NAME);						
//						//query.findInBackground(new FindCallback<ParseObject>() {
//							//@Override
//							//public void done(List<ParseObject> userObject, ParseException e) {
//								// TODO Auto-generated method stub
//								//if (e == null && userObject.size() > 0) {
//									GroupDataModel gModel = new GroupDataModel();
//									gModel.setTitle(ifEmpty(groupName));
//									gModel.setLink(ifEmpty(groupIcon));
//									gModel.setGroup_info(ifEmpty(groupObject.get(i).getString(GROUP_INFO_CLASS)));
//									callback.onDataReceived(gModel);
//								//}
//							//}
//						//});
//					}
//				}else{
//					callback.onDataReceivedError("Error");
//				}
//			}
//		 });
//		
//	}
//	
////	private void getUserGroupList(final OnDataReceived callback,final String groupParent) {
////		// TODO Auto-generated method stub
////		ParseQuery<ParseObject> query = ParseQuery.getQuery(USER_CLASS);
////		query.whereEqualTo(USER_NAME,ReceiverApplication.USER_NAME);
////		query.findInBackground(new FindCallback<ParseObject>() {
////			@Override
////			public void done(List<ParseObject> userObject, ParseException e) {
////				// TODO Auto-generated method stub
////				if (e == null && userObject.size() > 0) {
////					JSONArray groupArray = userObject.get(0).getJSONArray(USER_GROUP_LIST);
////						for(int i =0 ;i < groupArray.length();i++){
////							try {
////								String groupName  = (String) groupArray.get(i);
////								ParseQuery<ParseObject> query = ParseQuery.getQuery(GROUP);
////								query.whereEqualTo(GROUP_TITLE,groupName);
////								query.whereContains(GROUP_PARENT,groupParent);
////								query.findInBackground(new FindCallback<ParseObject>() {
////									@Override
////									public void done(List<ParseObject> groupObject, ParseException e) {
////										// TODO Auto-generated method stub
////										if (e == null && groupObject.size() > 0) {
////											
////											int k = groupObject.size();
////											//LinkedHashMap<String, ArrayList<VendorDataModel>> vendorCategories = new LinkedHashMap<String, ArrayList<VendorDataModel>>();
////											
////											for(int i=0;i<k;i++){
////												GroupDataModel gModel = new GroupDataModel();
////												gModel.setTitle(ifEmpty(groupObject.get(i).getString(GROUP_TITLE)));
////												gModel.setLink(ifEmpty(groupObject.get(i).getString(GROUP_IMAGE_URL)));
////												callback.onDataReceived(gModel);
////												
////											}
////											
////										}else{
////											callback.onDataReceivedError("Error");
////										}
////									}
////								 });
////							} catch (JSONException e1) {
////								// TODO Auto-generated catch block
////								e1.printStackTrace();
////							}
////						}
////						
////					
////					
////				}else{
////					callback.onDataReceivedError("Error");
////				}
////			}
////		 });
////		
////	}
//	
//	
//
//	public  void makePostRequest(int request, Object id, Object data,Object callback){
//		
//		switch(request){
//		
//		case REGISTER_USER:
//			 register((User)data, (OnResultCallBack)callback);
//			 break;
////		case REGISTER_USER_GROUP:
////			 registerGroup((ArrayList<String>)id, (String)data, (OnResultCallBack)callback);
////			 break;
//		case GET_GROUP_MESSAGE:
//			 getGroupMessages((String)data, (OnDataReceived)callback);
//			 break;
//		case POST_GROUP_MESSAGE:
//			 postGroupMessages((String)id,(MessageDataModel)data, (OnDataReceived)callback);
//			 break;
//		case POST_MESSAGE_STATUS:
//			 postMessageStatus((String)id,(Boolean)data, (OnDataReceived)callback);
//		}
//	}
//	
//	private void postMessageStatus(String id, final boolean data,final OnDataReceived callback) {
//		// TODO Auto-generated method stub
//		ParseQuery<ParseObject> query = ParseQuery.getQuery(ReceiverApplication.groupStack.get(0));
//		query.whereEqualTo(MESSAGE_ID,id);
//		query.findInBackground(new FindCallback<ParseObject>() {
//			@Override
//			public void done(List<ParseObject> messageObject, ParseException e) {
//				// TODO Auto-generated method stub
//				if (e == null && messageObject.size() > 0) {
//					messageObject.get(0).put(MESSAGE_APPROVE_STATUS, data);
//					messageObject.get(0).saveInBackground();
//					callback.onDataReceived(null);
//				}
//			}
//		});
//	}
//
//
//	private void postGroupMessages(final String groupName,final  MessageDataModel messageModel,final OnDataReceived callback) {
//		// TODO Auto-generated method stub
//		ParseObject message = new ParseObject(groupName);
//		message.put(MESSAGE_SENT_BY, messageModel.getSenderName());
//		if(!TextUtils.isEmpty(messageModel.getMessageText()))
//		message.put(MESSAGE_TEXT, messageModel.getMessageText());	
//		if(!TextUtils.isEmpty(messageModel.getMessagePic()))
//		message.put(MESSAGE_PIC_URL,messageModel.getMessagePic());
//		if(!TextUtils.isEmpty(messageModel.getMessageVid()))
//		message.put(MESSAGE_VID_URL,messageModel.getMessageVid());
//		if(!TextUtils.isEmpty(messageModel.getMessageMp3()))
//			message.put(MESSAGE_MP3_URL,messageModel.getMessageMp3());
//		message.put(MESSAGE_APPROVE_STATUS,messageModel.isApprove());
//		message.saveInBackground();		
//    	callback.onDataReceived("");
//		
//	}
//	
////	private void registerGroup(ArrayList<String> userName,final String groupName,final OnResultCallBack callback) {
////		// TODO Auto-generated method stub
////		ParseQuery<ParseObject> query = ParseQuery.getQuery(USER_CLASS);
////		query.whereContainedIn(USER_NAME,userName);
////		query.findInBackground(new FindCallback<ParseObject>() {
////			@Override
////			public void done(List<ParseObject> userObjects, ParseException e) {
////				// TODO Auto-generated method stub
////				if (e == null && userObjects.size() > 0) {
////					for(int i=0;i<userObjects.size();i++){
////						JSONArray oldArray = userObjects.get(i).getJSONArray(USER_GROUP_LIST);
////						if(oldArray == null)
////							oldArray = new JSONArray();
////						oldArray.put(groupName);
////						userObjects.get(i).put(USER_GROUP_LIST, oldArray);
////						userObjects.get(i).saveInBackground();
////					}
////					callback.onSuccess();
////				}else{
////					callback.onFailure();
////				}
////			}
////		});
////	}
//	
//	
//	private void register(final User user,final OnResultCallBack callback) {
//		// TODO Auto-generated method stub
//		ParseQuery<ParseObject> query = ParseQuery.getQuery(USER_CLASS);
//		query.whereEqualTo(USER_NAME,user.getName());
//		query.findInBackground(new FindCallback<ParseObject>() {
//			@Override
//			public void done(List<ParseObject> serviceObject, ParseException e) {
//				// TODO Auto-generated method stub
//				if (e == null && serviceObject.size() > 0) {
//					//already registered
//					callback.onSuccess();
//				}else if(serviceObject.size() == 0){
//					
//					ParseObject customer = new ParseObject(USER_CLASS);
//					customer.put(USER_NAME, user.getName());
//					customer.put(USER_PHONE, user.getPhonenumber());
//					customer.put(USER_LOCATION, user.getAddress());
//					//customer.put(USER_GROUP_LIST, user.getGroup());
//
//					customer.saveInBackground(new SaveCallback() {						
//						@Override
//						public void done(ParseException arg0) {
//							ParsePush.subscribeInBackground("user", new SaveCallback() {
//								  @Override
//								  public void done(ParseException e) {
//								    if (e == null) {
//								      Log.d("com.parse.push", "successfully subscribed to the broadcast channel.");
//								      callback.onSuccess();
//								    } else {
//								      Log.e("com.parse.push", "failed to subscribe for push", e);
//								    }
//								  }
//								});
//						}
//					});					
//				}else{
//					callback.onFailure();
//				}
//			}
//		});
//	}
//	
//	
//
//
//	private  void deleteMessage(String id) {
//		// TODO Auto-generated method stub
//		ParseQuery<ParseObject> query = ParseQuery.getQuery(ReceiverApplication.USER_SOCIETY_DATA_CLASS);
//		query.whereEqualTo(COLUMN_MESSAGE_ID, id);
//		query.findInBackground(new FindCallback<ParseObject>() {
//			@Override
//			public void done(List<ParseObject> opinionObject, ParseException e) {
//				opinionObject.get(0).deleteInBackground();
//			}});
//	}
//	
//	
//	
//
//	
//
//	
//	
//	
//	
//	
//	
//	private  String ifEmpty(String value){
//		if(value == null)
//			return "";
//		else
//			return value;
//	}
//	
//	private void syncTimeQuery(String updateTag, ParseQuery query){
//		String lastUpdateddate = PrefUtil.getString(ReceiverApplication.getAppContext(), updateTag);
//		if(!TextUtils.isEmpty(lastUpdateddate)){	
//			//Tue Feb 10 05:10:24 CST 2015
//			SimpleDateFormat formatter = new SimpleDateFormat("EEEE MMM dd HH:mm:ss z yyyy");
//			try {
//				Date lastTimeSynced = formatter.parse(lastUpdateddate);
//				query.whereGreaterThan("updatedAt", lastTimeSynced);
//				Log.d("date",lastTimeSynced.toString());
//			} catch (java.text.ParseException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			
//		}
//	}
//	
//	private void saveSynctime(String updateTag, Date lastTimeSynced){
//		PrefUtil.putString(ReceiverApplication.getAppContext(), updateTag, lastTimeSynced.toString());
//	}
//	
//	private void saveData(String DATA_TAG, Object fetcheddata){
//		Gson gson = new Gson();
//		String data = gson.toJson(fetcheddata);
//		PrefUtil.putString(ReceiverApplication.getAppContext(), DATA_TAG, data);
//	}
//	
//	

}
