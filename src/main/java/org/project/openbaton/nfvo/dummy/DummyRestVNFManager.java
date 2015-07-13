package org.project.openbaton.nfvo.dummy;

import org.project.openbaton.nfvo.catalogue.mano.common.LifecycleEvent;
import org.project.openbaton.nfvo.catalogue.mano.record.VirtualNetworkFunctionRecord;
import org.project.openbaton.nfvo.catalogue.nfvo.Action;
import org.project.openbaton.nfvo.catalogue.nfvo.CoreMessage;
import org.project.openbaton.nfvo.common.vnfm.rest.AbstractVnfmSpringReST;
import org.springframework.boot.SpringApplication;

/**
 * Created by lto on 27/05/15.
 */

public class DummyRestVNFManager extends AbstractVnfmSpringReST{

    @Override
    public void instantiate(VirtualNetworkFunctionRecord vnfr) {
        log.info("Instantiation of VirtualNetworkFunctionRecord " + vnfr.getName());
        log.trace("Instantiation of VirtualNetworkFunctionRecord " + vnfr);
        boolean allocate = false;

        log.debug("Number of events: " + vnfr.getLifecycle_event().size());
        log.trace("I've finished initialization of vnf " + vnfr.getName() + " in facts there are only " + vnfr.getLifecycle_event().size() + " events");
        vnfr.setName("Updated Name");
        CoreMessage coreMessage = new CoreMessage();
        coreMessage.setAction(Action.INSTANTIATE_FINISH);
        coreMessage.setPayload(vnfr);

        for (LifecycleEvent event : vnfr.getLifecycle_event()){
        } // for

        this.sendToCore(coreMessage);

//        if (!allocate) {
//        }
    }

    @Override
    public void query() {

    }

    @Override
    public void scale() {

    }

    @Override
    public void checkInstantiationFeasibility() {

    }

    @Override
    public void heal() {

    }

    @Override
    public void updateSoftware() {

    }

    @Override
    public void modify(VirtualNetworkFunctionRecord virtualNetworkFunctionRecord) {
        log.trace("Adding relation with VirtualNetworkFunctionRecord " + virtualNetworkFunctionRecord);
        log.debug("Adding relation with VirtualNetworkFunctionRecord " + virtualNetworkFunctionRecord.getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void upgradeSoftware() {

    }

    @Override
    public void terminate() {

    }

    public static void main(String[] args) {
        SpringApplication.run(DummyRestVNFManager.class, args);
    }
}
