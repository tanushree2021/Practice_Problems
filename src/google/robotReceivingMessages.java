package google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*
 * Robot receiving messages and need to print messages on a screen

1. With Input messages given, do not print duplicate messages if time frame is 10 seconds

10 loaded oil
11 engine warning
12 tire rolling
13 loaded oil
14 engine warning
21 loaded oil
35 loaded oil


User Screen

10 loaded oil
11 engine warning
12 tire rolling
35 loaded oil


Bug in Robot, print only unique messages within 10 seconds time frame

12 tire rolling
35 loaded oil
2. Bug in Robot, print only unique messages within 10 seconds time frame
 */
class Message {

	static List<Message> messages = new ArrayList<>();

	private long ts;
	private String message;

	Message() {
		messages.add(new Message(10, "Loaded Oil"));
		messages.add(new Message(11, "engine warning"));
		messages.add(new Message(12, "tire rolling"));
		messages.add(new Message(13, "Loaded Oil"));
		messages.add(new Message(14, "engine warning"));
		messages.add(new Message(21, "Loaded Oil"));
		messages.add(new Message(35, "Loaded Oil"));
	}

	public Message(long ts, String message) {
		super();
		this.ts = ts;
		this.message = message;
	}

	public long getTs() {
		return ts;
	}

	public void setTs(long ts) {
		this.ts = ts;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

//	static int count=0;
//	public static Message getMessages() {
//		return messages.get(count++);
//	}

}

public class robotReceivingMessages {

	public static void main(String[] args) {

		Map<String, Long> map = new HashMap<>();
		filterDuplicateMessages(map);
//		removeDuplicateWrtTimeFrame();
	}

	private static void removeDuplicateWrtTimeFrame() {
		Map<String, Long> uniqueMsgMap = new LinkedHashMap<>();
		int count = 0;
		Message msg = new Message();
		while (true) {
			if (count < 7) {
				Message currentMsg = Message.messages.get(count++);

				String actualMsg = currentMsg.getMessage();
				long currentTimeStamp = currentMsg.getTs();

				for (Map.Entry<String, Long> entry : uniqueMsgMap.entrySet()) {
					if (currentTimeStamp - entry.getValue() > 10) {
						if (entry.getKey() != actualMsg) {
							System.out.println(entry.getValue() + " " + entry.getKey());
						} else {
							System.out.println(currentTimeStamp + " " + actualMsg);
						}
					}
				}
				if (uniqueMsgMap.containsKey(actualMsg) && currentTimeStamp - uniqueMsgMap.get(actualMsg) < 10) {
					uniqueMsgMap.remove(actualMsg);
				} else {
					uniqueMsgMap.put(actualMsg, currentTimeStamp);
				}
//				System.out.println(" Map at count " + count + " is " + uniqueMsgMap);
			}
		}
	}

	private static void filterDuplicateMessages(Map<String, Long> map) {
		int count = 0;
		Message msg = new Message();
		while (true) {
			if (count < 7) {
				Message currentMsg = Message.messages.get(count++);

				String actualMsg = currentMsg.getMessage();
				long currentTimeStamp = currentMsg.getTs();
				if (map.containsKey(actualMsg)) {
					long oldTimeStamp = map.get(actualMsg);
					if (currentTimeStamp - oldTimeStamp > 10) {
						System.out.println(currentTimeStamp + " " + actualMsg);
					}
					map.put(actualMsg, currentTimeStamp);
				} else {
					System.out.println(currentTimeStamp + " " + actualMsg);
					map.put(actualMsg, currentTimeStamp);
				}
			}
		}
	}
}
