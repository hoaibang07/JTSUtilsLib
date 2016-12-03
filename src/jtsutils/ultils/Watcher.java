package jtsutils.ultils;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;
import static java.nio.file.StandardWatchEventKinds.OVERFLOW;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

/**
 * Class mô tả việc lắng nghe thư mục, file
 * @author hbc
 *
 */
public class Watcher implements Runnable {
	private String dirPath;

	/**
	 * Tao doi tuong watcher de lang nghe su thay doi cua directory
	 * @param dirPath
	 * 		directory path
	 */
	public Watcher(String dirPath) {
		this.dirPath = dirPath;
	}

	@Override
	public void run() {
		WatchService watcher;
		try {
			watcher = FileSystems.getDefault().newWatchService();
			Path dir = Paths.get(dirPath);

			// register create, modify and delete
			dir.register(watcher, ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE);

			// ReportUT.report("Watch Service registered for dir: " +
			// dir.getFileName());

			Report.report("Listening directory " + dir);

			while (true) {
				WatchKey key;
				key = watcher.take();
				for (WatchEvent<?> event : key.pollEvents()) {
					WatchEvent.Kind<?> kind = event.kind();

					@SuppressWarnings("unchecked")
					WatchEvent<Path> ev = (WatchEvent<Path>) event;
					Path fileName = ev.context();

					Report.report(kind.name() + ": " + fileName);

					if (kind == OVERFLOW) {
						continue;
					}
					// else if (kind == ENTRY_CREATE) {
					//
					// // process create event
					//
					// } else if (kind == ENTRY_DELETE) {
					//
					// // process delete event
					//
					// } else if (kind == ENTRY_MODIFY) {
					//
					// // process modify event
					// }
				}

				// IMPORTANT: The key must be reset after processed
				boolean valid = key.reset();
				if (!valid) {
					break;
				}
			}
		} catch (InterruptedException | IOException ext) {
			ext.printStackTrace();
		}
	};
}
