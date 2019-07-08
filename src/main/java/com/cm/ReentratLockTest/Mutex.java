package com.cm.ReentratLockTest;

import java.io.Serializable;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class Mutex implements Serializable {
    private static class Sync extends AbstractQueuedSynchronizer {
        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        @Override
        public boolean tryAcquire(int accquire) {
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int release) {
            if (getState() == 1) throw new IllegalMonitorStateException();
            setExclusiveOwnerThread(null);
            setState(0);
            return true;

        }

    }

    private final Sync sync = new Sync();

    public void lock() {
        sync.tryAcquire(1);
    }

    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    public void unlock() {
        sync.release(1);
    }

    public boolean islocked() {
        return sync.isHeldExclusively();
    }
}
