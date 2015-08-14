package com.opentext.ecm.otsync.ws.server;

import com.opentext.ecm.otsync.listeners.ChunkedContentRequestQueue;
import com.opentext.ecm.otsync.ws.ServletConfig;

public class CleanUpThread extends Thread {
	private ClientSet clients;
	private volatile boolean stopFlag = true;
	private ChunkedContentRequestQueue chunkedQueue;
	
	public CleanUpThread(ClientSet clients, ChunkedContentRequestQueue chunkedQueue) {
		super("cleanup");
		this.clients = clients;
		this.chunkedQueue = chunkedQueue;
	}

	@Override
	public void run() {	
		stopFlag = false;
		while (!stopFlag) {
			try {
				Thread.sleep(ServletConfig.getCleanUpInterval() * 1000);
			}
			catch (InterruptedException ex) {
				// continue on and wake up from sleep
			}
			
			clients.discardOldClients();
			chunkedQueue.cleanDownloadRequests();
			chunkedQueue.cleanUploadRequests();
		}
	}
	
	public synchronized void stopThread() {
		if(stopFlag) return;
		stopFlag = true;
		this.interrupt();
	}

}