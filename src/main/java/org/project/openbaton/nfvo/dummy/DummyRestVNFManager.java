package org.project.openbaton.nfvo.dummy;

import org.project.openbaton.catalogue.mano.common.LifecycleEvent;
import org.project.openbaton.catalogue.mano.record.VNFRecordDependency;
import org.project.openbaton.catalogue.mano.record.VirtualNetworkFunctionRecord;
import org.project.openbaton.catalogue.nfvo.Action;
import org.project.openbaton.catalogue.nfvo.CoreMessage;
import org.project.openbaton.common.vnfm_sdk.exception.VnfmSdkException;
import org.project.openbaton.common.vnfm_sdk.rest.AbstractVnfmSpringReST;
import org.springframework.boot.SpringApplication;

import java.lang.annotation.Annotation;

/**
 * Created by lto on 27/05/15.
 */
public class DummyRestVNFManager extends AbstractVnfmSpringReST {

    @Override
    public VirtualNetworkFunctionRecord instantiate(VirtualNetworkFunctionRecord vnfr) {
        log.info("Instantiation of VirtualNetworkFunctionRecord " + vnfr.getName());
        log.trace("Instantiation of VirtualNetworkFunctionRecord " + vnfr);
        boolean allocate = false;

        log.debug("Number of events: " + vnfr.getLifecycle_event().size());
        log.trace("I've finished initialization of vnf " + vnfr.getName() + " in facts there are only " + vnfr.getLifecycle_event().size() + " events");
        vnfr.setName("Updated Name");
        CoreMessage coreMessage = new CoreMessage();
        coreMessage.setAction(Action.INSTANTIATE_FINISH);

        for (LifecycleEvent event : vnfr.getLifecycle_event()){
        } // for

        this.sendToCore(coreMessage);

//        if (!allocate) {
//        }
        return vnfr;
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
    public VirtualNetworkFunctionRecord modify(VirtualNetworkFunctionRecord virtualNetworkFunctionRecord, VNFRecordDependency dependency) {
        log.trace("Adding relation with VirtualNetworkFunctionRecord " + virtualNetworkFunctionRecord);
        log.debug("Adding relation with VirtualNetworkFunctionRecord " + virtualNetworkFunctionRecord.getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return virtualNetworkFunctionRecord;
    }


    @Override
    public void upgradeSoftware() {

    }

    @Override
    public CoreMessage terminate(VirtualNetworkFunctionRecord virtualNetworkFunctionRecord) {
        return null;
    }

    @Override
    public CoreMessage handleError(VirtualNetworkFunctionRecord virtualNetworkFunctionRecord) {
        return null;
    }

    @Override
    protected CoreMessage start(VirtualNetworkFunctionRecord virtualNetworkFunctionRecord) {
        return null;
    }

    @Override
    protected String executeActionOnEMS(String s, String s1) throws VnfmSdkException {
        return null;
    }

    @Override
    protected CoreMessage configure(VirtualNetworkFunctionRecord virtualNetworkFunctionRecord) {
        return null;
    }

    public static void main(String[] args) {
        for (Annotation a : DummyRestVNFManager.class.getAnnotations())
            System.out.println("Annotation: " + a);
        SpringApplication.run(DummyRestVNFManager.class, args);
    }

    @Override
    public void NotifyChange() {

    }
}
